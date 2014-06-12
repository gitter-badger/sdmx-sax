/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.SAXException;
import sdmx.message.StructureType;
import sdmx.SdmxIO;
import sdmx.version.common.SdmxParserProvider;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;
import sdmx.Registry;
import sdmx.data.DataSetWriter;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.data.structured.StructuredDataWriter;
import sdmx.version.twopointone.generic.GenericData21ContentHandler;
import sdmx.version.twopointone.generic.GenericData21EventHandler;
import sdmx.version.twopointone.structurespecific.StructureSpecificContentHandler;
import sdmx.version.twopointone.structurespecific.StructureSpecificEventHandler;
import sdmx.version.twopointzero.compact.CompactDataContentHandler;
import sdmx.version.twopointzero.compact.CompactDataEventHandler;

/**
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class Sdmx21ParserProvider implements SdmxParserProvider {

    static {
        SdmxIO.register(new Sdmx21ParserProvider());
    }

    @Override
    public int getVersionIdentifier() {
        return SdmxIO.VERSION21;
    }

    public static boolean isSdmx21(String header) {
        if (header.indexOf("StructureSpecificTimeSeriesData ") != -1) {
            return true;
        } else if (header.indexOf("GenericTimeSeriesData ") != -1) {
            return true;
        } else if (header.indexOf("GenericData ") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificTimeSeriesData ") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificData ") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificData ") != -1) {
            return true;
        } else if (header.indexOf("Structure ") != -1 && header.indexOf("\"http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message\"") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean canParse(String header) {
        return isSdmx21(header);
    }

    @Override
    public StructureType parseStructure(InputStream in) {
        try {
            return Sdmx21StructureReaderTools.toStructureDocument(in);
        } catch (XmlException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean isStructure(String header) {
        if (header.indexOf(":Structure ") != -1) {
            return true;
        } else if (header.indexOf("<Structure ") != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isData(String header) {
        if (header.indexOf("GenericData") != -1) {
            return true;
        } else if (header.indexOf("GenericTimeSeriesData") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificData") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificTimeSeriesData") != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isMetadata(String header) {
        if (header.indexOf("GenericMetadata") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificMetadata") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public StructureType parseStructure(Registry registry, InputStream in) throws IOException {
        StructureType st = parseStructure(in);
        registry.load(st);
        return st;
    }

    public boolean isStructureSpecificData(String header) {
        if (header.indexOf("StructureSpecificData ") != -1) {
            return true;
        } else if (header.indexOf("StructureSpecificTimeSeriesData ") != -1) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isGenericData(String header) {
        if (header.indexOf("GenericData ") != -1) {
            return true;
        } else if (header.indexOf("GenericTimeSeriesData ") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public DataMessage parseData(String header, InputStream in) throws IOException {
        if (isStructureSpecificData(header)) {
           return parseStructureSpecificData(in,false);
        }
        if( isGenericData(header)){
            return parseGenericData(in,false);
        }
        return null;
    }

    public DataMessage parseStructureSpecificData(InputStream in,boolean flat) throws IOException {
        DataSetWriter writer = flat?new FlatDataSetWriter():new StructuredDataWriter();
        StructureSpecificEventHandler event = new StructureSpecificEventHandler(writer);
        StructureSpecificContentHandler handler = new StructureSpecificContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    @Override
    public StructureType parseStructure(Reader in) throws IOException {
        try {
            return Sdmx21StructureReaderTools.toStructureDocument(in);
        } catch (XmlException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StructureType parseStructure(Registry registry, Reader in) throws IOException {
        StructureType st = parseStructure(in);
        registry.load(st);
        return st;
    }

    @Override
    public DataMessage parseData(String header, Reader in) throws IOException {
        if (isStructureSpecificData(header)) {
           return parseStructureSpecificData(in,false);
        }
        if( isGenericData(header)){
            return parseGenericData(in,false);
        }
        return null;
    }

    @Override
    public DataMessage parseData(String header, InputStream in, boolean flat) throws IOException {
        if (isStructureSpecificData(header)) {
           return parseStructureSpecificData(in,flat);
        }
        if( isGenericData(header)){
            return parseGenericData(in,flat);
        }
        return null;
    }

    @Override
    public DataMessage parseData(String header, Reader in, boolean flat) throws IOException {
        if (isStructureSpecificData(header)) {
           return parseStructureSpecificData(in,flat);
        }
        if( isGenericData(header)){
            return parseGenericData(in,flat);
        }
        return null;
    }

    public DataMessage parseStructureSpecificData(Reader in, boolean flat) throws IOException {
        DataSetWriter writer = flat?new FlatDataSetWriter():new StructuredDataWriter();
        StructureSpecificEventHandler event = new StructureSpecificEventHandler(writer);
        StructureSpecificContentHandler handler = new StructureSpecificContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseGenericData(InputStream in,boolean flat) throws IOException {
        System.out.println("Parse Generic Data");
        DataSetWriter writer = flat?new FlatDataSetWriter():new StructuredDataWriter();
        GenericData21EventHandler event = new GenericData21EventHandler(writer);
        GenericData21ContentHandler handler = new GenericData21ContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            ex.printStackTrace();
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }
    public DataMessage parseGenericData(Reader in,boolean flat) throws IOException {
        DataSetWriter writer = flat?new FlatDataSetWriter():new StructuredDataWriter();
        GenericData21EventHandler event = new GenericData21EventHandler(writer);
        GenericData21ContentHandler handler = new GenericData21ContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx21ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

}
