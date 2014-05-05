/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.io.PushbackReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.xml.sax.SAXException;
import sdmx.message.StructureType;
import sdmx.version.twopointone.Sdmx21ParserProvider;
import sdmx.version.twopointzero.Sdmx20ParserProvider;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;
import sdmx.version.common.SdmxParserProvider;
import sdmx.registry.LocalRegistry;

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
    
    private static List<SdmxParserProvider> list = new ArrayList<SdmxParserProvider>(0);
    public static void register(SdmxParserProvider pp) {
        list.add(pp);
    }
    static{
        try {
            Class.forName("sdmx.version.twopointone.Sdmx21ParserProvider");
            Class.forName("sdmx.version.twopointzero.Sdmx20ParserProvider");
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
        pushback.unread(buf, 0, read);
        byte[] buf2 = new byte[read];
        System.arraycopy(buf, 0, buf2, 0, read);
        String header = new String(buf2);
        return header;
    }    
    public static String getHeader(PushbackReader pushback) throws IOException {
        char[] buf = new char[8192];
        int read = pushback.read(buf);
        pushback.unread(buf, 0, read);
        
        char[] buf2 = new char[read];
        System.arraycopy(buf, 0, buf2, 0, read);
        String header = new String(buf2);
        //System.out.println("Header="+header);
        return header;
    }    
    public static int checkVersion(String header) {
        for(int i=0;i<list.size();i++) {
            if( list.get(i).canParse(header))return list.get(i).getVersionIdentifier();
        }
        return UNKNOWN;
    }
    public static int checkVersion(PushbackInputStream push) throws IOException {
        String header = getHeader(push);
        for(int i=0;i<list.size();i++) {
            if( list.get(i).canParse(header))return list.get(i).getVersionIdentifier();
        }
        return UNKNOWN;
    }
    public static StructureType parseStructure(InputStream in) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        return parseStructure(new LocalRegistry(),in);
    }
    public static StructureType parseStructure(Reader in) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        return parseStructure(new LocalRegistry(),in);
    }
    public static StructureType parseStructure(Registry registry,InputStream in) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findProvider(header);
        StructureType struct =  prov.parseStructure(registry,push);
        return struct;
    }
    public static StructureType parseStructure(Registry registry,Reader in) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findProvider(header);
        StructureType struct =  prov.parseStructure(registry,push);
        return struct;
    }
    public static DataMessage parseData(InputStream in) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findProvider(header);
        return prov.parseData(header,push);
    }
    public static DataMessage parseData(Reader in) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findProvider(header);
        return prov.parseData(header,push);
    }
    public static DataMessage parseData(InputStream in,boolean flat) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackInputStream push = new PushbackInputStream(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findProvider(header);
        return prov.parseData(header,push,flat);
    }
    public static DataMessage parseData(Reader in,boolean flat) throws IOException {
        if( in == null ) throw new IllegalArgumentException("Null Stream");
        PushbackReader push = new PushbackReader(in,8192);
        String header = getHeader(push);
        SdmxParserProvider prov = findProvider(header);
        return prov.parseData(header,push,flat);
    }
    public static SdmxParserProvider findProvider(String header) throws IOException {
        for(int i=0;i<list.size();i++) {
            if( list.get(i).canParse(header))return list.get(i);
        }
        return null;
    }
}
