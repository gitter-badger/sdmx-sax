/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.xmlbeans.XmlException;
import org.xml.sax.SAXException;
import sdmx.exception.TypeValueNotFoundException;
import sdmx.message.StructureType;
import sdmx.version.common.SdmxIO;
import sdmx.version.common.SdmxParserProvider;
import sdmx.version.twopointone.Sdmx21ParserProvider;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;
import sdmx.version.twopointzero.compact.CompactDataContentHandler;
import sdmx.version.twopointzero.compact.CompactDataEventHandler;
import sdmx.version.twopointzero.generic.GenericDataContentHandler;
import sdmx.version.twopointzero.generic.GenericDataEventHandler;
import sdmx.workspace.LocalRegistry;
import sdmx.workspace.Registry;

/**
 *
 * @author James
 */
public class Sdmx20ParserProvider implements SdmxParserProvider {

    static {
        SdmxIO.register(new Sdmx20ParserProvider());
    }

    public static boolean isSdmx20(String header) {
        if (header.indexOf("CompactData ") != -1) {
            return true;
        } else if (header.indexOf("GenericData") != -1) {
            return true;
        } else if (header.indexOf("GenericData") != -1) {
            return true;
        } else if (header.indexOf("CrossSectionalData") != -1) {
            return true;
        } else if (header.indexOf("<Structure xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
            return true;
        } else if (header.indexOf(":Structure xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
            return true;
        } else if (header.indexOf("Structure") != -1 && header.indexOf("\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
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
    public StructureType parseStructure(InputStream in) {
        try {
            StructureType doc;
            doc = new Sdmx20StructureReaderTools(LocalRegistry.getDefaultWorkspace()).parseStructure(in);
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public StructureType parseStructure(Reader in) {
        try {
            StructureType doc;
            doc = new Sdmx20StructureReaderTools(LocalRegistry.getDefaultWorkspace()).parseStructure(in);
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public boolean isStructure(String header) {
        if (header.indexOf("<message:Structure xmlns=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
            return true;
        } else if (header.indexOf("<message:Structure xmlns:message=\"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message\"") != -1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isData(String header) {
        if (header.indexOf("CompactData ") != -1) {
            return true;
        } else if (header.indexOf("GenericData ") != -1) {
            return true;
        } else if (header.indexOf("CrossSectionalData") != -1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isCompactData(String header) {
        if (header.indexOf("CompactData ") != -1) {
            return true;
        } else if (header.indexOf("GenericData ") != -1) {
            return false;
        } else {
            return false;
        }
    }
    
    public boolean isGenericData(String header) {
        if (header.indexOf("GenericData ") != -1) {
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
    public DataMessage parseData(String header,InputStream in) throws IOException {
       if( isCompactData(header))return parseCompactData(in);
       if( isGenericData(header))return parseGenericData(in);
       return null;
    }

    @Override
    public StructureType parseStructure(Registry registry, InputStream in) throws IOException {
        try {
            StructureType doc;
            doc = new Sdmx20StructureReaderTools(registry).parseStructure(in);
            return doc;
        } catch (XmlException | IOException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TypeValueNotFoundException ex) {
            Logger.getLogger(Sdmx20ParserProvider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    @Override
    public StructureType parseStructure(Registry registry, Reader in) throws IOException {
        try {
            StructureType doc;
            doc = new Sdmx20StructureReaderTools(registry).parseStructure(in);
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

    @Override
    public DataMessage parseData(String header, Reader in) throws IOException {
       if( isCompactData(header))return parseCompactData(in);
       if( isGenericData(header))return parseGenericData(in);
       return null;
    }
}