/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.xml.sax.SAXException;
import sdmx.commonreferences.DataStructureReference;
import sdmx.data.flat.FlatDataSet;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.net.LocalRegistry;
import sdmx.net.ServiceList;
import sdmx.net.list.DataProvider;
import sdmx.structure.dataflow.DataflowType;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.ParseParams;
import sdmx.version.common.SdmxParserProvider;
import sdmx.version.common.SdmxStreamWriterProvider;
import sdmx.version.common.SdmxWriterProvider;
import sdmx.version.twopointone.Sdmx21ParserProvider;
import sdmx.version.twopointzero.Sdmx20ParserProvider;

/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class SdmxIO {
    private static boolean SAVE_XML = false;
    private static boolean DUMP_QUERY = false;
    private static boolean DUMP_XML = false;
    private static boolean SANITISE_NAMES = false;
    private static boolean STRICT_REGEX = false;
    private static boolean IGNORE_CASE = true;
    private static boolean CHECK_URN = true;
    private static int LOG_LEVEL = 1;
    private static Handler h = new ConsoleHandler();
    static{
        SdmxIO.setLogLevel(LOG_LEVEL);
        h.setLevel(Level.ALL);
        Logger.getLogger("sdmx").addHandler(h);
    }
    
    public static final List<String> SAVE_MIME_TYPES = new ArrayList<String>();
    
    private static List<SdmxParserProvider> parsers = new ArrayList<SdmxParserProvider>(0);
    private static List<SdmxWriterProvider> writers = new ArrayList<SdmxWriterProvider>(0);    
    private static List<SdmxStreamWriterProvider> streamWriters = new ArrayList<SdmxStreamWriterProvider>(0);
    
    public static void register(SdmxParserProvider pp) {
        parsers.add(pp);
    }
    public static void register(SdmxWriterProvider pp) {
        writers.add(pp);
    }
    public static void register(SdmxStreamWriterProvider pp) {
        streamWriters.add(pp);
    }
    
    static{
        try {
            Class.forName("sdmx.version.twopointone.Sdmx21ParserProvider");
            Class.forName("sdmx.version.twopointone.Sdmx21MessageWriterProvider");
            Class.forName("sdmx.version.twopointone.Sdmx21StreamWriterProvider");
            Class.forName("sdmx.version.twopointzero.Sdmx20ParserProvider");
            Class.forName("sdmx.version.json.JSONStreamWriterProvider");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SdmxIO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static final int UNKNOWN = -1;
    public static final int VERSION10 = 0;
    public static final int VERSION20 = 1;
    public static final int VERSION21 = 2;

    public static String getHeader(PushbackInputStream pushback) throws IOException {
        byte[] buf = new byte[8192];
        int read = pushback.read(buf);
        int total = read;
        int retries = 1000;
        while(total<100&&retries>0) {
            read=pushback.read(buf,total,buf.length-total);
            total+=read;
            retries--;
        }
        if( retries == 0 ) {
            throw new RuntimeException("Retry Limit Reached!");
        }
        pushback.unread(buf, 0, total);
        byte[] buf2 = new byte[total];
        System.arraycopy(buf, 0, buf2, 0, total);
        String header = new String(buf2);
        return header;
    }    
    public static String getHeader(PushbackReader pushback) throws IOException {
        try{Thread.sleep(300);}catch(InterruptedException ie) {}
        char[] buf = new char[8192];
        int read = pushback.read(buf);
        int total = read;
        while(total<100) {
            read=pushback.read(buf,total,buf.length-total);
            total+=read;
        }
        pushback.unread(buf, 0, total);
        char[] buf2 = new char[total];
        System.arraycopy(buf, 0, buf2, 0, total);
        String header = new String(buf2);
        //System.out.println("Header="+header);
        return header;
    }    
    public static int checkVersion(String header) {
        for(int i=0;i<parsers.size();i++) {
            if( parsers.get(i).canParse(header))return parsers.get(i).getVersionIdentifier();
        }
        return UNKNOWN;
    }
    public static int checkVersion(PushbackInputStream push) throws IOException {
        String header = getHeader(push);
        for(int i=0;i<parsers.size();i++) {
            if( parsers.get(i).canParse(header))return parsers.get(i).getVersionIdentifier();
        }
        return UNKNOWN;
    }
    public static StructureType parseStructure(InputStream in) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        ParseParams params = new ParseParams();
        params.setRegistry(new LocalRegistry());
        return parseStructure(params,in);
        
    }
    public static StructureType parseStructure(Reader in) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        ParseParams params = new ParseParams();
        params.setRegistry(new LocalRegistry());
        return parseStructure(params,in);
    }
    public static StructureType parseStructure(ParseParams params,InputStream in) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        params.setHeader(header);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider header="+header);
        }
        StructureType struct =  prov.parseStructure(params,push);
        params.getRegistry().load(struct);
        return struct;
    }
    public static StructureType parseStructure(ParseParams params,Reader in) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        params.setHeader(header);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider");
        }
        StructureType struct =  prov.parseStructure(params,push);
        params.getRegistry().load(struct);
        return struct;
    }
    public static DataMessage parseData(InputStream in1) throws IOException,ParseException {
        if( in1 == null ) throw new IllegalArgumentException("Null Stream");
        BufferedInputStream in = null;
        if( !(in1 instanceof BufferedInputStream) ) {
            in = new BufferedInputStream(in1);
        }else{
            in = (BufferedInputStream)in1;
        }
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider"+header);
        }
        ParseParams params = new ParseParams();
        params.setHeader(header);
        return prov.parseData(params,push);
    }
    public static DataMessage parseData(Reader in) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider");
        }
        ParseParams params = new ParseParams();
        params.setHeader(header);
        return prov.parseData(params,push);
    }
    public static void parseData(InputStream in,ParseDataCallbackHandler cbHandler) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider");
        }
        ParseParams params = new ParseParams();
        params.setHeader(header);
        params.setCallbackHandler(cbHandler);
        prov.parseData(params,push);
    }
    public static void parseData(ParseParams params,InputStream in,ParseDataCallbackHandler cbHandler) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider");
        }
        params.setHeader(header);
        params.setCallbackHandler(cbHandler);
        prov.parseData(params,push);
    }
    
    public static void parseData(Reader in,ParseDataCallbackHandler cbHandler) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider");
        }
        ParseParams params = new ParseParams();
        params.setHeader(header);
        params.setCallbackHandler(cbHandler);
        prov.parseData(params,push);
    }
    
    public static void parseData(ParseParams params,Reader in,ParseDataCallbackHandler cbHandler) throws IOException,ParseException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findParserProvider(header);
        if( prov==null ) {
            throw new ParseException("Unable to find Parser provider");
        }
        params.setHeader(header);
        params.setCallbackHandler(cbHandler);
        prov.parseData(params,push);
    }
    
    public static SdmxParserProvider findParserProvider(String header) throws IOException {
        for(int i=0;i<parsers.size();i++) {
            if( parsers.get(i).canParse(header))return parsers.get(i);
        }
        return null;
    }
    public static SdmxWriterProvider findWriterProvider(String mime) throws IOException {
        for(int i=0;i<writers.size();i++) {
            if( writers.get(i).getSupportedMIMETypes().contains(mime)) return writers.get(i);
        }
        return null;
    }
    public static SdmxStreamWriterProvider findStreamWriterProvider(String mime) throws IOException {
        for(int i=0;i<streamWriters.size();i++) {
            if( streamWriters.get(i).getSupportedMIMETypes().contains(mime)) return streamWriters.get(i);
        }
        return null;
    }
    public static boolean isSaveXml() { return SAVE_XML; }
    public static void setSaveXml(boolean b) { SAVE_XML =b; }
    public static boolean isDumpQuery() { return DUMP_QUERY; }
    public static void setDumpQuery(boolean b) { DUMP_QUERY =b; }
    public static boolean isDumpXml() { return DUMP_XML; }
    public static void setDumpXml(boolean b) { DUMP_XML =b; }
    public static boolean isSanitiseNames() { return SANITISE_NAMES; }
    public static void setSanitiseNames(boolean b) { SANITISE_NAMES =b; }
    public static boolean isStrictRegex() { return STRICT_REGEX; }
    public static void setStrictRegex(boolean b) { STRICT_REGEX =b; }
    public static boolean isIgnoreCase() { return IGNORE_CASE; }
    public static void setIgnoreCase(boolean b) { IGNORE_CASE=b; }
    public static boolean isCheckURN() { return CHECK_URN; }
    public static void setCheckURN(boolean b) { CHECK_URN=b; }
    public static int getLogLevel() { return LOG_LEVEL; }
    public static void setLogLevel(int i) { 
        LOG_LEVEL=i; 
        Level level = Level.ALL;
        switch(LOG_LEVEL){
            case 0:level=Level.OFF;break;
            case 1:level=Level.INFO;break;
            case 2:level=Level.CONFIG;break;
            case 3:level=Level.WARNING;break;
            case 4:level=Level.FINE;break;
            case 5:level=Level.FINER;break;
            case 6:level=Level.FINEST;break;
            case 7:level=Level.ALL;break;
        }
        Logger.getLogger("sdmx").setLevel(level);
        Logger.getLogger("sdmx").setUseParentHandlers(false);
    }
    public static Queryable connect(int type, String agency,String serviceURL,String options,String attribution,String htmlAttribution) throws MalformedURLException {
        return ServiceList.getDataProvider(type, agency, serviceURL, options, attribution, htmlAttribution).getQueryable();
    }
    public static ParseDataCallbackHandler openForStreamWriting(String mime,OutputStream out1,ParseParams params) throws IOException {
        SdmxStreamWriterProvider provider = findStreamWriterProvider(mime);
        if( provider == null ) {
            throw new RuntimeException("Not Writer found for MIME type:"+mime);
        }
        BufferedOutputStream out = new BufferedOutputStream(out1);
        return provider.openForWriting(mime, out, params);
    }
    public static void write(String mime,DataMessage message,OutputStream out) throws IOException {
        SdmxWriterProvider writer = findWriterProvider(mime);
        if( writer==null) {
            throw new RuntimeException("Not Writer found for MIME type:"+mime);
        }
        writer.save(mime, out, message);
    }
    public static void write(String mime,StructureType message,OutputStream out) throws IOException {
        SdmxWriterProvider writer = findWriterProvider(mime);
        if( writer==null) {
            throw new RuntimeException("Not Writer found for MIME type:"+mime);
        }
        writer.save(mime, out, message);
    }
    public static List<String> listSupportedWriteMIMETypes() {
        List<String> result = new ArrayList<String>();
        for(SdmxWriterProvider p:writers) {
            result.addAll(p.getSupportedMIMETypes());
        }
        return result;
    }
    public static List<String> listSupportedStreamWriteMIMETypes() {
        List<String> result = new ArrayList<String>();
        for(SdmxStreamWriterProvider p:streamWriters) {
            result.addAll(p.getSupportedMIMETypes());
        }
        return result;
    }
    public static List<String> listStructureMIMETypes() {
        return STRUCT_MIMES;
    }
    private static List<String> DATA_MIMES = new ArrayList<String>();
    static{
        DATA_MIMES.add("application/vnd.sdmx.genericdata+xml;version=2.1");
        DATA_MIMES.add("application/vnd.sdmx.generictimeseriesdata+xml;version=2.1");
        DATA_MIMES.add("application/vnd.sdmx.structurespecificdata+xml;version=2.1");
        DATA_MIMES.add("application/vnd.sdmx.structurespecifictimeseriesdata+xml;version=2.1");
        DATA_MIMES.add("application/vnd.sdmx.data+json;version=1.0.0-wd");
    }
    private static List<String> STRUCT_MIMES = new ArrayList<String>();
    static{
        STRUCT_MIMES.add("application/vnd.sdmx.structure+xml;version=2.1");
    }
    public static List<String> listDataMIMETypes() {
        return DATA_MIMES;
    }
}
