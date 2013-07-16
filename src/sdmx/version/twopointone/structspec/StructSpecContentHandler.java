/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.structspec;

/**
 *
 * @author James
 */
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import sdmx.message.DataMessage;
import sdmx.version.twopointone.Sdmx21ContentHandler;

public class StructSpecContentHandler extends Sdmx21ContentHandler implements ContentHandler, ErrorHandler {

    InputStream in = null;
    XMLReader reader = null;
    boolean parsed = false;
    // Delegate Events Here!
    StructSpecEventHandler eh = null;
    List<String> groupNames = null;

    public StructSpecContentHandler(InputStream in, StructSpecEventHandler handler) {
        super();
        this.in = in;
        this.eh = handler;
    }

    public StructSpecContentHandler(InputStream in) {
        this(in, new StructSpecEventHandler());
    }

    public DataMessage parse() throws SAXException, IOException {
        parsed = true;
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(this);
        reader.setErrorHandler(this);
        reader.parse(new InputSource(in));
        DataMessage doc = eh.
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
        System.out.println("start=" + localName+" qName="+qName);
        for (int i = 0; i < atts.getLength(); i++) {
            System.out.println("Att=" + atts.getLocalName(i) + " val=" + atts.getValue(i));
        }
         *
         */
        if( "Header".equals(localName) ) {
            eh.startHeader();
        }else if( "ID".equals(localName)) {
            eh.startHeaderID();
        }else if( "Test".equals(localName)) {
            eh.startHeaderTest();
        }else if( "Prepared".equals(localName)) {
            eh.startHeaderPrepared();
        }else if( "Sender".equals(localName)) {
                eh.startHeaderSender(atts);
        }else if( "message:Structure".equals(qName)) {
            eh.startStructure(atts);
        }else if( "common:Structure".equals(qName)) {
            eh.startCommonStructure(atts);
        }else if( "Ref".equals(localName)) {
            // This 'Ref' has the qName 'Ref' in the example..
            eh.startRef(atts);
        }else if( "DataSet".equals(localName)) {
            eh.startDataSet(uri,atts);
        }else if( "Series".equals(localName)) {
            eh.startSeries(uri,atts);
        }else if( "Obs".equals(localName)) {
            eh.startObs(uri,atts);
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
        //System.out.println("end=" + localName);
        if( "Header".equals(localName) ) {
            eh.endHeader();
        }else if( "ID".equals(localName)) {
            
        }else if( "Test".equals(localName)) {
            
        }else if( "Prepared".equals(localName)) {
            
        }else if( "Sender".equals(localName)) {
            
        }else if( "message:Structure".equals(qName)) {
            
        }else if( "Ref".equals(localName)) {
            
        }else if( "common:Structure".equals(qName)) {
            
        }else if( "DataSet".equals(localName)) {
            eh.endDataSet();
        }else if( "Series".equals(localName)) {
            eh.endSeries();
        }else if( "Obs".equals(localName)) {
            eh.endObs();
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        try {
            char[] c2 = new char[length];
            System.arraycopy(ch, start, c2, 0, length);
            eh.characters(c2);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Sdmx21ContentHandler.class.getName()).log(Level.SEVERE, null, ex);
            throw new SAXException(ex.getMessage());
        }
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
