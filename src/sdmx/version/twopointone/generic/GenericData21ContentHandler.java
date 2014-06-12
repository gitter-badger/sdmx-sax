/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.generic;

/**
 *
 * @author James
 */
import sdmx.version.twopointone.generic.*;
import java.beans.PropertyVetoException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import sdmx.message.DataMessage;

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
public class GenericData21ContentHandler implements ContentHandler, ErrorHandler {

    InputStream in = null;
    Reader in2 = null;
    XMLReader reader = null;
    boolean parsed = false;
    // Delegate Events Here!
    GenericData21EventHandler eh = null;
    List<String> groupNames = new ArrayList<String>();

    public GenericData21ContentHandler(InputStream in) {
        super();
        this.in = in;
        this.eh = new GenericData21EventHandler();
    }

    public GenericData21ContentHandler(Reader in) {
        super();
        this.in2 = in;
        this.eh = new GenericData21EventHandler();
    }

    public GenericData21ContentHandler(Reader in, GenericData21EventHandler handler) {
        super();
        this.in2 = in;
        this.eh = handler;
    }

    public GenericData21ContentHandler(InputStream in, GenericData21EventHandler handler) {
        super();
        this.in = in;
        this.eh = handler;
    }

    public DataMessage parse() throws SAXException, IOException {
        parsed = true;
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        if (this.in != null) {
            reader.parse(new InputSource(in));
        } else {
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
        //System.out.println("localName=" + localName);
        //for (int i = 0; i < atts.getLength(); i++) {
//            System.out.println("Att=" + atts.getLocalName(i) + " val=" + atts.getValue(i));
//        }
        if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message".equalsIgnoreCase(uri)) {
            if ("GenericData".equals(localName)) {
                eh.startRootElement(atts);
            } else if ("MessageGroup".equals(localName)) {
                eh.startRootElement(atts);
            } else if ("Header".equals(localName)) {
                eh.startHeader();
            } else if ("ID".equals(localName)) {
                eh.startHeaderID();
            } else if ("Test".equals(localName)) {
                eh.startHeaderTest();
            } else if ("Name".equals(localName)) {
                eh.startName(uri, atts);
            } else if ("Truncated".equals(localName)) {
                eh.startHeaderTruncated();
            } else if ("Prepared".equals(localName)) {
                eh.startHeaderPrepared();
            } else if ("Sender".equals(localName)) {
                eh.startHeaderSender(atts);
            } else if ("DataSetAction".equals(localName)) {
                eh.startDataSetAction(atts);
            } else if ("Extracted".equals(localName)) {
                eh.startExtracted(atts);
            } else if ("ReportingBegin".equals(localName)) {
                eh.startReportingBegin(atts);
            } else if ("ReportingEnd".equals(localName)) {
                eh.startReportingEnd(atts);
            } else if ("Contact".equals(localName)) {
                eh.startContact(atts);
            } else if ("Telephone".equals(localName)) {
                eh.startTelephone(atts);
            } else if ("Department".equals(localName)) {
                eh.startDepartment(atts);
            } else if ("X400".equals(localName)) {
                eh.startX400(atts);
            } else if ("Fax".equals(localName)) {
                eh.startFax(atts);
            } else if ("Receiver".equals(localName)) {
                eh.startReceiver(atts);
            } else if ("Role".equals(localName)) {
                eh.startRole(atts);
            } else if ("URI".equals(localName)) {
                eh.startURI(atts);
            } else if ("Email".equals(localName)) {
                eh.startEmail(atts);
            } else if ("Structure".equals(localName)) {
                eh.startMessageStructure(atts);;
            } else if ("DataSet".equals(localName)) {
                eh.startDataSet(uri, atts);
            }
        }
        if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common".equalsIgnoreCase(uri)) {
            if ("Structure".equals(localName)) {
                eh.startCommonStructure(atts);;
            }
        }
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_1/generic".equalsIgnoreCase(uri)) {

            if ("Series".equals(localName)) {
                eh.startSeries(uri, atts);
            } else if ("Obs".equals(localName)) {
                eh.startObs(uri, atts);
            } else if ("Attributes".equals(localName)) {
                eh.startAttributes(uri, atts);
            } else if ("ObsKey".equals(localName)) {
                eh.startObsKey(uri, atts);
            } else if ("ObsValue".equals(localName)) {
                eh.startObsValue(uri, atts);
            } else if ("ObsDimension".equals(localName)) {
                eh.startObsDimension(uri, atts);
            } else if ("SeriesKey".equals(localName)) {
                eh.startSeriesKey(uri, atts);
            } else if ("GroupKey".equals(localName)) {
                eh.startGroupKey(uri, atts);
            } else if ("Value".equals(localName)) {
                eh.startValue(uri, atts);
            } else if ("Group".equals(localName)) {
                eh.startGroup(uri, atts);
            }
        }
        if ("Ref".equals(localName)) {
            eh.startRef(atts);
        }

    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        //System.out.println("END" + localName);
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_1/message".equalsIgnoreCase(uri)) {
            if ("GenericData".equals(localName)) {
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
            } else if ("DataSetAction".equals(localName)) {
                eh.endDataSetAction();
            } else if ("Extracted".equals(localName)) {
                eh.endExtracted();
            } else if ("ReportingBegin".equals(localName)) {
                eh.endReportingBegin();
            } else if ("ReportingEnd".equals(localName)) {
                eh.endReportingEnd();
            } else if ("Contact".equals(localName)) {
                eh.endContact();
            } else if ("Telephone".equals(localName)) {
                eh.endTelephone();
            } else if ("Department".equals(localName)) {
                eh.endDepartment();
                //} else if ("X400".equals(localName)) {
                //    eh.endX400();
            } else if ("Fax".equals(localName)) {
                eh.endFax();
            } else if ("Receiver".equals(localName)) {
                eh.endReceiver();
            } else if ("Role".equals(localName)) {
                eh.endRole();
            } else if ("URI".equals(localName)) {
                eh.endURI();
            } else if ("Email".equals(localName)) {
                eh.endEmail();
            } else if ("Structure".equals(localName)) {
                eh.endMessageStructure();;
            } else if ("DataSet".equals(localName)) {
                System.out.println("End DataSet");
                eh.endDataSet();
            }
        }
        if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common".equalsIgnoreCase(uri)) {
            if ("Structure".equals(localName)) {
                eh.endCommonStructure();;
            }
        }
        if ("http://www.SDMX.org/resources/SDMXML/schemas/v2_1/generic".equalsIgnoreCase(uri)) {

            if ("Series".equals(localName)) {
                eh.endSeries();
            } else if ("Obs".equals(localName)) {
                eh.endObs();
            } else if ("Attributes".equals(localName)) {
                eh.endAttributes();
                // }else if ("ObsKey".equals(localName)) {
                //  eh.endObsKey();
            } else if ("ObsValue".equals(localName)) {
                eh.endObsValue();
                //} else if ("ObsDimension".equals(localName)) {
                //    eh.endObsDimension();
            } else if ("SeriesKey".equals(localName)) {
                eh.endSeriesKey();
            } else if ("GroupKey".equals(localName)) {
                eh.endGroupKey();
            } else if ("Value".equals(localName)) {
                eh.endValue();
            } else if ("Group".equals(localName)) {
                eh.endGroup();
            }
        }
        if ("Ref".equals(localName)) {
            eh.endRef();
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
