/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero.generic;

/**
 *
 * @author James
 */
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import sdmx.message.DataMessage;
import sdmx.version.twopointzero.Sdmx20ContentHandler;
import sdmx.version.twopointzero.generic.GenericDataEventHandler;

public class GenericDataContentHandler extends Sdmx20ContentHandler {

    InputStream in = null;
    Reader in2 = null;
    XMLReader reader = null;
    boolean parsed = false;
    // Delegate Events Here!
    GenericDataEventHandler eh = null;
    List<String> groupNames = new ArrayList<String>();

    public GenericDataContentHandler(InputStream in) {
        super();
        this.in = in;
        this.eh = new GenericDataEventHandler();
    }

    public GenericDataContentHandler(Reader in) {
        super();
        this.in2 = in;
        this.eh = new GenericDataEventHandler();
    }

    public GenericDataContentHandler(GenericDataEventHandler handler,Reader in) {
        super();
        this.in2 = in;
        this.eh = handler;
    }
    public GenericDataContentHandler(GenericDataEventHandler handler,InputStream in) {
        super();
        this.in = in;
        this.eh = handler;
    }

    public DataMessage parse() throws SAXException, IOException {
        parsed = true;
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        if( this.in!=null) {
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
         * */
        /*
         * System.out.println("localName=" + localName);
         for (int i = 0; i < atts.getLength(); i++) {
         System.out.println("Att=" + atts.getLocalName(i) + " val=" + atts.getValue(i));
         }
         *
         */
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(uri)) {
            if ("GenericData".equals(localName)) {
                eh.startRootElement(atts);
            }else if ("MessageGroup".equals(localName)) {
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
            eh.startDataSet(uri, atts);
        }
        if ("KeyFamilyRef".equals(localName)) {
            eh.startKeyFamilyRef(uri, atts);
        } else if ("Series".equals(localName)) {
            eh.startSeries(uri, atts);
        } else if ("Obs".equals(localName)) {
            eh.startObs(uri, atts);
        } else if ("Value".equals(localName)) {
            eh.startValue(uri, atts);
        } else if ("Time".equals(localName)) {
            eh.startTime(uri, atts);
        } else if ("Attributes".equals(localName)) {
            eh.startAttributes(uri, atts);
        } else if ("SeriesKey".equals(localName)) {
            eh.startSeriesKey(uri, atts);
        } else if ("GroupKey".equals(localName)) {
            eh.startGroupKey(uri, atts);
        } else if ("ObsValue".equals(localName)) {
            eh.startObsValue(uri, atts);
        } else if ("Group".equals(localName)) {
            eh.startGroup(uri, atts);
        }
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("END" + localName);
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(uri)) {
            if ("GenericData".equals(localName)) {
                eh.endRootElement();
            } else if ("MessageGroup".equals(localName)) {
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
        }
        if ("KeyFamilyRef".equals(localName)) {
            eh.endKeyFamilyRef();
        } else if ("Series".equals(localName)) {
            eh.endSeries();
        } else if ("Obs".equals(localName)) {
            eh.endObs();
        } else if ("Value".equals(localName)) {
            eh.endValue();
        } else if ("Time".equals(localName)) {
            eh.endTime();
        } else if ("Attributes".equals(localName)) {
            eh.endAttributes();
        } else if ("SeriesKey".equals(localName)) {
            eh.endSeriesKey();
        } else if ("GroupKey".equals(localName)) {
            eh.endGroupKey();
        } else if ("ObsValue".equals(localName)) {
            eh.endObsValue();
        } else if ("Group".equals(localName)) {
            eh.endGroup();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
//        try {
        char[] c2 = new char[length];
        System.arraycopy(ch, start, c2, 0, length);
        eh.characters(c2);
        //            eh.characters(c2);
        //        } catch (PropertyVetoException ex) {
        //            Logger.getLogger(Sdmx20ContentHandler.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        }


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
