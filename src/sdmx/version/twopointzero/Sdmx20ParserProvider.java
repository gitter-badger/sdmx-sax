/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLStreamException;
import org.apache.xmlbeans.XmlException;
import org.jdom.Namespace;
import org.xml.sax.SAXException;
import sdmx.Registry;
import sdmx.data.DataSetWriter;
import sdmx.data.flat.FlatDataSet;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.data.structured.StructuredDataWriter;
import sdmx.exception.TypeValueNotFoundException;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.SdmxIO;
import sdmx.version.common.SdmxParserProvider;
import sdmx.version.twopointone.Sdmx21ParserProvider;
import sdmx.version.twopointzero.compact.CompactDataContentHandler;
import sdmx.version.twopointzero.compact.CompactDataEventHandler;
import sdmx.version.twopointzero.generic.GenericDataContentHandler;
import sdmx.version.twopointzero.generic.GenericDataEventHandler;
import sdmx.version.twopointzero.writer.CompactDataWriter;
import sdmx.net.LocalRegistry;
import sdmx.version.common.ParseDataCallbackHandler;

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
public class Sdmx20ParserProvider implements SdmxParserProvider {

    static {
        SdmxIO.register(new Sdmx20ParserProvider());
    }

    public static boolean isSdmx20(String header) {
        if (header.indexOf("CompactData") != -1) {
            return true;
        } else if (header.indexOf("MessageGroup") != -1) {
            return true;
        } else if (header.indexOf("GenericData") != -1) {
            return true;
        } else if (header.indexOf("RegistryInterface") != -1) {
            return true;
        } else if (header.indexOf("GenericData") != -1) {
            return true;
        } else if (header.indexOf("CrossSectionalData") != -1) {
            return true;
        } else if (header.indexOf("<Structure xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
            return true;
        } else if (header.indexOf(":Structure xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
            return true;
        } else if (header.indexOf("Structure") != -1 && header.indexOf("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getVersionIdentifier() {
        return SdmxIO.VERSION20;
    }

    @Override
    public boolean canParse(String header) {
        if (isSdmx20(header)) {
            return true;
        }
        return false;
    }

    @Override
    public StructureType parseStructure(InputStream in, String header) throws IOException {
        try {
            StructureType doc;
            if (!isRegistryInterface(header)) {
                doc = new Sdmx20StructureReaderTools(LocalRegistry.getDefaultWorkspace()).parseStructure(in);
            } else {
                doc = new Sdmx20StructureReaderTools(LocalRegistry.getDefaultWorkspace()).parseRegistry(in);
            }
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public StructureType parseStructure(Reader in, String header) {
        try {
            StructureType doc;
            if (!isRegistryInterface(header)) {
                doc = new Sdmx20StructureReaderTools(LocalRegistry.getDefaultWorkspace()).parseStructure(in);
            } else {
                doc = new Sdmx20StructureReaderTools(LocalRegistry.getDefaultWorkspace()).parseRegistry(in);
            }
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isStructure(String header) {
        if (header.indexOf("Structure ") != -1) {
            return true;
        } else if (header.indexOf("RegistryInterface ") != -1) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isRegistryInterface(String header) {
        if (header.indexOf("RegistryInterface ") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isData(String header) {
        if (header.indexOf("CompactData") != -1) {
            return true;
        } else if (header.indexOf("GenericData") != -1) {
            return true;
        } else if (header.indexOf("CrossSectionalData") != -1) {
            return true;
        } else if (header.indexOf("MessageGroup") != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCompactData(String header) {
        if (header.indexOf("CompactData") != -1) {
            return true;
        } else if (header.indexOf("GenericData") != -1) {
            return false;
        } else {
            return false;
        }
    }

    public boolean isGenericData(String header) {
        if (header.indexOf("GenericData") != -1) {
            return true;
        }
        if (header.indexOf("MessageGroup") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isMetadata(String header) {
        return false;
    }

    @Override
    public DataMessage parseData(String header, InputStream in) throws IOException {
        if (isCompactData(header)) {
            return parseCompactData(in);
        }
        if (isGenericData(header)) {
            return parseGenericData(in);
        }
        return null;
    }

    @Override
    public StructureType parseStructure(Registry registry, InputStream in, String header) throws IOException {
        try {
            StructureType doc;
            if (!isRegistryInterface(header)) {
                doc = new Sdmx20StructureReaderTools(registry).parseStructure(in);
            } else {
                doc = new Sdmx20StructureReaderTools(registry).parseRegistry(in);
            }
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public StructureType parseStructure(Registry registry, Reader in, String header) throws IOException {
        try {
            StructureType doc;
            if (!isRegistryInterface(header)) {
                doc = new Sdmx20StructureReaderTools(registry).parseStructure(in);
            } else {
                doc = new Sdmx20StructureReaderTools(registry).parseRegistry(in);
            }
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DataMessage parseCompactData(InputStream in) throws IOException {
        CompactDataEventHandler event = new CompactDataEventHandler();
        CompactDataContentHandler handler = new CompactDataContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseGenericData(InputStream in) throws IOException {
        GenericDataContentHandler handler = new GenericDataContentHandler(in);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseCompactData(InputStream in,ParseDataCallbackHandler cbHandler) throws IOException {
        DataSetWriter writer = cbHandler!=null?cbHandler.getDataSetWriter():new StructuredDataWriter();
        CompactDataEventHandler event = new CompactDataEventHandler(writer);
        event.setCbHandler(cbHandler);
        CompactDataContentHandler handler = new CompactDataContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseGenericData(InputStream in, ParseDataCallbackHandler cbHandler) throws IOException {
        DataSetWriter writer = cbHandler!=null?cbHandler.getDataSetWriter():new StructuredDataWriter();
        GenericDataEventHandler event = new GenericDataEventHandler(writer);
        GenericDataContentHandler handler = new GenericDataContentHandler(event, in);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseCompactData(Reader in) throws IOException {
        CompactDataEventHandler event = new CompactDataEventHandler();
        CompactDataContentHandler handler = new CompactDataContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseGenericData(Reader in) throws IOException {
        GenericDataContentHandler handler = new GenericDataContentHandler(in);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseCompactData(Reader in, ParseDataCallbackHandler cbHandler) throws IOException {
        DataSetWriter writer = cbHandler!=null?cbHandler.getDataSetWriter():new StructuredDataWriter();
        CompactDataEventHandler event = new CompactDataEventHandler(writer);
        event.setCbHandler(cbHandler);
        CompactDataContentHandler handler = new CompactDataContentHandler(in, event);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    public DataMessage parseGenericData(Reader in, ParseDataCallbackHandler cbHandler) throws IOException {
        DataSetWriter writer = cbHandler!=null?cbHandler.getDataSetWriter():new StructuredDataWriter();
        GenericDataEventHandler event = new GenericDataEventHandler(writer);
        GenericDataContentHandler handler = new GenericDataContentHandler(event, in);
        try {
            return handler.parse();
        } catch (SAXException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return null;
    }

    @Override
    public DataMessage parseData(String header, Reader in) throws IOException {
        if (isCompactData(header)) {
            return parseCompactData(in);
        }
        if (isGenericData(header)) {
            return parseGenericData(in);
        }
        return null;
    }

    @Override
    public DataMessage parseData(String header, InputStream in, ParseDataCallbackHandler cbHandler) throws IOException {
        if (isCompactData(header)) {
            return parseCompactData(in, cbHandler);
        }
        if (isGenericData(header)) {
            return parseGenericData(in, cbHandler);
        }
        return null;
    }

    @Override
    public DataMessage parseData(String header, Reader in, ParseDataCallbackHandler cbHandler) throws IOException {
        if (isCompactData(header)) {
            return parseCompactData(in, cbHandler);
        }
        if (isGenericData(header)) {
            return parseGenericData(in, cbHandler);
        }
        return null;
    }

    public void writeDataMessage(DataMessage msg, OutputStream out) throws XMLStreamException {
        CompactDataWriter.write(msg, out);
    }
}
