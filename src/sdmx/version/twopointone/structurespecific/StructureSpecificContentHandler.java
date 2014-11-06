/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.structurespecific;

/**
 *
 * @author James
 */
import sdmx.version.twopointzero.compact.*;
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
import sdmx.NewRegistry;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;
import sdmx.message.StructureType;
import sdmx.version.twopointzero.Sdmx20ContentHandler;

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
public class StructureSpecificContentHandler extends Sdmx20ContentHandler implements ContentHandler, ErrorHandler {

    InputStream in = null;
    Reader in2 = null;
    XMLReader reader = null;
    boolean parsed = false;
    // Delegate Events Here!
    StructureSpecificEventHandler eh = null;
    List<String> groupNames = null;

    public StructureSpecificContentHandler(InputStream in, StructureSpecificEventHandler handler) {
        super();
        this.in = in;
        this.eh = handler;
    }

    public StructureSpecificContentHandler(Reader in, StructureSpecificEventHandler handler) {
        super();
        this.in2 = in;
        this.eh = handler;
    }

    public StructureSpecificContentHandler(NewRegistry registry, InputStream in, StructureType struct) {
        this(in, new StructureSpecificEventHandler());
    }

    public StructureSpecificContentHandler(NewRegistry registry, Reader in, StructureType struct) {
        this(in, new StructureSpecificEventHandler());
    }

    public DataMessage parse() throws SAXException, IOException {
        parsed = true;
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        if (in != null) {
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
         */
        //System.out.println("localName=" + localName);
        //for (int i = 0; i < atts.getLength(); i++) {
//            System.out.println("Att=" + atts.getLocalName(i) + " val=" + atts.getValue(i));
//        }
        if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message".equals(uri)) {
            if ("StructureSpecificTimeSeriesData".equals(localName)) {
                eh.startRootElement(atts);
            } else if ("StructureSpecificData".equals(localName)) {
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
            } else if ("DataSet".equalsIgnoreCase(localName)) {
                //System.out.println("StartDataSet");
                try {
                    eh.startDataSet(uri, qName, atts);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(StructureSpecificContentHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common".equals(uri)) {
            if ("Structure".equals(localName)) {
                eh.startCommonStructure(atts);;
            }
        } else {
            if ("Series".equalsIgnoreCase(localName)) {
                eh.startSeries(uri, atts);
            } else if ("Obs".equalsIgnoreCase(localName)) {
                eh.startObs(uri, atts);
            } else if (localName.indexOf("Group") != -1) {
                eh.startGroup(localName, atts);
            } else if ("Ref".equalsIgnoreCase(localName)) {
                eh.startRef(atts);
            } else if ("URN".equalsIgnoreCase(localName)) {
                eh.startURN(atts);
            } else if ("DataSet".equalsIgnoreCase(localName)) {
                //System.out.println("StartDataSet");
                try {
                    eh.startDataSet(uri, qName, atts);
                } catch (URISyntaxException ex) {
                    Logger.getLogger(StructureSpecificContentHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        //if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message".equals(uri)) {
        if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/message".equals(uri)) {
            if ("StructureSpecificTimeSeriesData".equals(localName)) {
                eh.endRootElement();
            } else if ("StructureSpecificData".equals(localName)) {
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
            } else if ("X400".equals(localName)) {
                eh.endtX400();
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
                eh.endMessageStructure();
            } else if ("http://www.sdmx.org/resources/sdmxml/schemas/v2_1/common".equals(uri)) {
                if ("Structure".equals(localName)) {
                    //eh.endCommonStructure();;
                }
            } else if ("DataSet".equals(localName)) {
                //System.out.println("EndDataSet");
                eh.endDataSet();
            }
        } else if ("Series".equals(localName)) {
            //System.out.println("EndSeries");
            eh.endSeries();
        } else if ("Obs".equals(localName)) {
            //System.out.println("EndObs");
            eh.endObs();
        } else if (localName.indexOf("Group") != -1) {
            eh.endGroup();
        } else if ("Ref".equals(localName)) {
            eh.endRef();
        } else if ("URN".equals(localName)) {
            eh.endURN();
        } else if ("DataSet".equals(localName)) {
            //System.out.println("EndDataSet");
            eh.endDataSet();
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
