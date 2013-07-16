/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero.compact;

/**
 *
 * @author James
 */
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.version.twopointzero.Sdmx20ContentHandler;
import sdmx.workspace.Registry;

public class CompactDataContentHandler extends Sdmx20ContentHandler implements ContentHandler, ErrorHandler {

    InputStream in = null;
    Reader in2 = null;
    XMLReader reader = null;
    boolean parsed = false;
    // Delegate Events Here!
    CompactDataEventHandler eh = null;
    List<String> groupNames = null;

    public CompactDataContentHandler(InputStream in, CompactDataEventHandler handler) {
        super();
        this.in = in;
        this.eh = handler;
    }
    public CompactDataContentHandler(Reader in, CompactDataEventHandler handler) {
        super();
        this.in2 = in;
        this.eh = handler;
    }

    public CompactDataContentHandler(Registry registry,InputStream in, StructureType struct) {
        this(in, new CompactDataEventHandler());
    }
    public CompactDataContentHandler(Registry registry,Reader in, StructureType struct) {
        this(in, new CompactDataEventHandler());
    }

    public DataMessage parse() throws SAXException, IOException {
        parsed = true;
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        if( in!=null ) {
           reader.parse(new InputSource(in));
        }else {
           reader.parse(new InputSource(in2));
        }
        DataMessage doc = eh.getDataMessage();
        return doc;
    }

    public void setDocumentLocator(Locator locator) {
    }

    public void startDocument() throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    public void endPrefixMapping(String prefix) throws SAXException {
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        // SDMX Defined Elements
            /*
         * This is really useful!!!
         */
        /*
        System.out.println("localName=" + localName);
        for (int i = 0; i < atts.getLength(); i++) {
        System.out.println("Att=" + atts.getLocalName(i) + " val=" + atts.getValue(i));
        }
        System.out.println(groupNames);
         */
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(uri)) {
            if ("MessageGroup".equals(localName)) {
                eh.startRootElement(atts);
            } else if ("CompactData".equals(localName)) {
                eh.startRootElement(atts);
            } else if ("Header".equals(localName)) {
                eh.startHeader();
            } else if ("ID".equals(localName)) {
                eh.startHeaderID();
            } else if ("Test".equals(localName)) {
                eh.startHeaderTest();
            } else if ("Name".equals(localName)) {
                eh.startName();
            } else if ("Truncated".equals(localName)) {
                eh.startHeaderTruncated();
            } else if ("Prepared".equals(localName)) {
                eh.startHeaderPrepared();
            } else if ("Sender".equals(localName)) {
                eh.startHeaderSender(atts);
            }
        }
        if ("DataSet".equals(localName)) {
            try {
                eh.startDataSet(uri, atts);
            } catch (URISyntaxException ex) {
                Logger.getLogger(CompactDataContentHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("Series".equals(localName)) {
            eh.startSeries(uri, atts);
        } else if ("Obs".equals(localName)) {
            eh.startObs(uri, atts);
        } else if (groupNames != null) {
            if (isStringInList(groupNames, localName)) {
                eh.startGroup(localName, atts);
            }

        }
    }

    public boolean isStringInList(List<String> list, String id) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        // SDMX Defined Elements
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(uri)) {
            if ("MessageGroup".equals(localName)) {
                eh.endRootElement();
            } else if ("CompactData".equals(localName)) {
                eh.endRootElement();
            } else if ("Header".equals(localName)) {
                eh.endHeader();
            } else if ("ID".equals(localName)) {
                eh.endHeaderID();
            } else if ("Test".equals(localName)) {
                eh.endHeaderTest();
            } else if ("Name".equals(localName)) {
                eh.endName();
            } else if ("Truncated".equals(localName)) {
                eh.endHeaderTruncated();
            } else if ("Prepared".equals(localName)) {
                eh.endHeaderPrepared();
            } else if ("Sender".equals(localName)) {
                eh.endHeaderSender();
            }
        }
        if ("DataSet".equals(localName)) {
            eh.endDataSet();
        } else if ("Series".equals(localName)) {
            eh.endSeries();
        } else if ("Obs".equals(localName)) {
            eh.endObs();
        } else if (groupNames != null) {
            if (isStringInList(groupNames, localName)) {
                eh.endGroup();
            }

        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        char[] c2 = new char[length];
        System.arraycopy(ch, start, c2, 0, length);
        eh.characters(c2);

    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }

    public void processingInstruction(String target, String data) throws SAXException {
    }

    public void skippedEntity(String name) throws SAXException {
    }

    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Warning:" + exception);
    }

    public void error(SAXParseException exception) throws SAXException {
        System.out.println("Error:" + exception);
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("Fatal:" + exception);
    }

}
