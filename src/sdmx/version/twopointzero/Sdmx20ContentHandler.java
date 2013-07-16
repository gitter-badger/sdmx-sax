/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero;

/**
 *
 * @author James
 */
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import sdmx.data.flat.FlatDataSet;
import sdmx.message.DataMessage;

public abstract class Sdmx20ContentHandler implements ContentHandler, ErrorHandler {
   public abstract DataMessage parse() throws SAXException, IOException ;
    public void setDocumentLocator(Locator locator) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startDocument() throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void endDocument() throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void endPrefixMapping(String prefix) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void processingInstruction(String target, String data) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void skippedEntity(String name) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void warning(SAXParseException exception) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void error(SAXParseException exception) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void fatalError(SAXParseException exception) throws SAXException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
