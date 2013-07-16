/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readsdmx.sdmx20.crosssection;

/**
 *
 * @author James
 */
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sdmx.resources.sdmxml.schemas.v2_0.message.CompactData;
import org.sdmx.resources.sdmxml.schemas.v2_0.message.Structure;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import readsdmx.model.DocumentFactory;
import readsdmx.model.immutable.DataDocument;
import readsdmx.model.meta.MetaDocumentStructure;
import readsdmx.sdmx20.Sdmx20ContentHandler;

public class CrossSectionalContentHandler extends Sdmx20ContentHandler implements ContentHandler, ErrorHandler {

    InputStream in = null;
    XMLReader reader = null;
    boolean parsed = false;
    // Delegate Events Here!
    CrossSectionalEventHandler eh = null;
    List<String> groupNames = null;

    public CrossSectionalContentHandler(InputStream in, CrossSectionalEventHandler handler) {
        super();
        this.in = in;
        this.eh = handler;
    }

    public CrossSectionalContentHandler(InputStream in, CrossSectionalDataStructureDocument docStruct, DocumentFactory factory) {
        this(in, new CrossSectionalEventHandler(factory, docStruct));
    }

    public DataDocument parse() throws SAXException, IOException {
        parsed = true;
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        reader.parse(new InputSource(in));
        DataDocument doc = eh.getDocument();
        return doc;
    }

    @Override
    public void setDocumentLocator(Locator locator) {
    }

    @Override
    public void startDocument() throws SAXException {
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
    }

    @Override
    public void endPrefixMapping(String prefix) throws SAXException {
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        // SDMX Defined Elements
        try {
            /*
             * This is really useful!!!
             */
/*
            System.out.println("localName=" + localName);
            for (int i = 0; i < atts.getLength(); i++) {
                System.out.println("Att=" + atts.getLocalName(i) + " val=" + atts.getValue(i));
            }
            System.out.println(groupNames);
 * 
 */
            if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(uri)) {
                if ("MessageGroup".equals(localName)) {
                    eh.startRootElement(atts);
                } else if ("CrossSectionalData".equals(localName)) {
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
                this.groupNames = eh.getGroupNames();
            } else if ("Series".equals(localName)) {
                eh.startSeries(uri, atts);
            } else if ("Section".equals(localName)) {
                eh.startSeries(uri, atts);
            } else if ("Obs".equals(localName)) {
                eh.startObs(uri, atts);
            } else if ("Group".equals(localName)) {
                eh.startGroup(uri, atts);
            } else if (groupNames != null) {
                if (isStringInList(groupNames, localName)) {
                    eh.startObs(localName, atts);
                }

            }
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Sdmx20ContentHandler.class.getName()).log(Level.SEVERE, null, ex);
            throw new SAXException(ex.getMessage());
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

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        // SDMX Defined Elements
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(uri)) {
            if ("MessageGroup".equals(localName)) {
                eh.endRootElement();
            } else if ("CrossSectionalData".equals(localName)) {
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
        } else if ("Section".equals(localName)) {
            eh.endSeries();
        } else if ("Obs".equals(localName)) {
            eh.endObs();
        }else if ("Group".equals(localName)) {
            eh.endGroup();
        } else if (groupNames != null) {
            if (isStringInList(groupNames, localName)) {
                eh.endObs();
            }
        }
    }

    @Override
    public void characters(char[] ch,
            int start,
            int length) throws SAXException {
        try {
            char[] c2 = new char[length];
            System.arraycopy(ch, start, c2, 0, length);
            eh.characters(c2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Sdmx20ContentHandler.class.getName()).log(Level.SEVERE, null, ex);
            throw new SAXException(ex.getMessage());
        }
    }

    @Override
    public void ignorableWhitespace(char[] ch,
            int start,
            int length) throws SAXException {
    }

    @Override
    public void processingInstruction(String target, String data) throws SAXException {
    }

    @Override
    public void skippedEntity(String name) throws SAXException {
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        System.out.println("Warning:" + exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        System.out.println("Error:" + exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        System.out.println("Fatal:" + exception);
    }
}
