/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero.writer;

/**
 *
 * @author James
 */
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import sdmx.common.Name;
import sdmx.data.DataSet;
import sdmx.data.ValueTypeResolver;
import sdmx.data.structured.Series;
import sdmx.data.structured.StructuredColumnMapper;
import sdmx.data.structured.StructuredDataSet;
import sdmx.message.*;

public class GenericDataWriter {

    public static void write(DataMessage message, DataStructure dsd, Namespace name, OutputStream out) throws XMLStreamException {
        //setup this like outputDocument
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(out);
        //output to a file
        writer.close();
    }

    /**
     *
     */
    public static void writeDataMessage(DataMessage msg, DataStructure dsd, XMLStreamWriter writer) throws XMLStreamException {
        // Create the root element
        writer.writeStartDocument();
        writer.writeStartElement("GenericData");
        writer.writeNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        writer.writeNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        writer.writeNamespace("common", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/common");
        writer.writeNamespace("compact", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/compact");
        writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        writer.writeNamespace("schemaLocation", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message http://www.sdmx.org/docs/2_0/SDMXMessage.xsd");
        writer.writeEndElement();
        writer.writeStartElement(null, "Header");
        Element header = new Element("Header");
        if (msg.getHeader().getId() != null && !"".equals(msg.getHeader().getId())) {
            writer.writeStartElement("ID");
            writer.writeCharacters(msg.getHeader().getId());
            writer.writeEndElement();
        }
        if (msg.getHeader().getTest() != null) {
            writer.writeStartElement("Test");
            writer.writeCharacters(msg.getHeader().getTest().toString());
            writer.writeEndElement();
        }
        if (msg.getHeader().getNames().size() > 0) {
            writer.writeStartElement("Name");
            writer.writeCharacters(msg.getHeader().getNames().get(0).getText());
            writer.writeEndElement();
        } else if (msg.getHeader().getNames().size() > 1) {
            writer.writeStartElement("Name");
            writer.writeCharacters(msg.getHeader().getNames().get(0).getText());
            writer.writeEndElement();
        }
        if (msg.getHeader().getPrepared() != null && !"".equals(msg.getHeader().getPrepared())) {
            writer.writeStartElement("Prepared");
            writer.writeCharacters(msg.getHeader().getPrepared().getDate().toString());
            writer.writeEndElement();
        }
        // Deprecated in SDMX 2.1
        //if (msg.getHeader().getTruncated() != null && !"".equals(msg.getHeader().getTruncated())) {
        //    Element trunc = new Element("Truncated");
        //    trunc.addContent(doc.getTruncated().toString());
        //    header.addContent(trunc);
        //}

        if (msg.getHeader().getSender() != null && !"".equals(msg.getHeader().getSender())) {
            writer.writeStartElement("Sender");
            writer.writeCharacters(msg.getHeader().getSender().getId().toString());
            if (msg.getHeader().getSender().getContacts().size() > 0) {
                writeContact(writer, msg.getHeader().getSender().getContacts().get(0));
            }
            writer.writeEndElement();
        }
        writer.writeStartElement("DataSet");

        DataSet ds = msg.getDataSets().get(0);
        if (msg.getHeader().getDataSetAction() != null && !"".equals(msg.getHeader().getDataSetAction())) {
            writer.writeAttribute("Action", msg.getHeader().getDataSetAction().getString());
        }
        if (msg.getHeader().getDataProvider().getRef().getAgencyId() != null) {
            writer.writeAttribute("DataFlowAgencyID", msg.getHeader().getDataProvider().getRef().getAgencyId().toString());
        }
        if (msg.getHeader().getDataSetID() != null && msg.getHeader().getDataSetID().size() > 0) {
            writer.writeAttribute("DataFlowID", msg.getHeader().getDataSetID().get(0).toString());
        }
        if (msg.getHeader().getDataProvider().getRef().getAgencyId() != null) {
            writer.writeAttribute("DataProviderID", msg.getHeader().getDataProvider().getRef().getAgencyId().toString());
        }
        if (msg.getHeader().getDataProvider().getRef().getAgencyId() != null) {
            writer.writeAttribute("DataProviderSchemeAgencyId", msg.getHeader().getDataProvider().getRef().getAgencyId().toString());
        }
        if (msg.getHeader().getDataProvider().getRef().getAgencyId() != null) {
            writer.writeAttribute("DataProviderSchemeId", msg.getHeader().getDataProvider().getRef().getId().toString());
        }
        if (msg.getHeader().getDataSetID() != null && msg.getHeader().getDataSetID().size() > 0) {
            writer.writeAttribute("DataSetID", msg.getHeader().getDataSetID().get(0).toString());
        }
        // Ignore.. no equivalient in SDMX 2.1
        //if (msg.getHeader().get) {
        //    dataSet.setAttribute("KeyFamilyURI", ds.getKeyFamilyURI());
        //}
        //if (msg.getHeader().getEmbargoDate() != null) {
        //    dataSet.setAttribute("PublicationPeriod", ds.getPublicationPeriod());
        //}
        //if (ds.getPublicationYear() != null) {
        //    dataSet.setAttribute("PublicationYear", ds.getPublicationYear());
        //}

        //for (int i = 0; i < ds.getGroupSize(); i++) {
        //    Group g = ds.getGroup(i);
        //    Element ge = new Element("Group");
// Ignore Groups for now
        //}
        if (ds instanceof StructuredDataSet) {
            StructuredDataSet sds = (StructuredDataSet) ds;
            StructuredColumnMapper mapper = (StructuredColumnMapper) sds.getColumnMapper();
            for (int i = 0; i < sds.getSeriesList().size(); i++) {
                writer.writeStartElement("Series");
                Series s = sds.getSeriesList().get(i);
                for (int j = 0; j < mapper.size(); j++) {
                    if (mapper.isAttachedToSeries(j)) {
                        writer.writeAttribute(mapper.getColumnName(j), ValueTypeResolver.columnToString(s.getValue(j)));
                    }
                }
                for (int k = 0; k < sds.getSeriesList().size(); i++) {
                    writer.writeStartElement("Observation");
                    for (int j = 0; j < mapper.size(); j++) {
                        if (mapper.isAttachedToSeries(j)) {
                            writer.writeAttribute(mapper.getColumnName(j), ValueTypeResolver.columnToString(sds.getSeries(i).getValue(j)));
                        }
                    }

                }
            }
        }
    }
    private static boolean isStringInList(List<String> list, String id) {
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (s.equals(id)) {
                return true;
            }
        }
        return false;
    }

    private static void writeText(XMLStreamWriter writer, String element, String lang, String text) throws XMLStreamException {
        writer.writeStartElement(element);
        writer.writeAttribute("xml:lang", lang);
        writer.writeCharacters(text);
        writer.writeEndElement();
    }

    public static void writeName(XMLStreamWriter writer, Name name) throws XMLStreamException {
        writeText(writer, "Name", name.getLang(), name.getText());
    }

    public static void writeContact(XMLStreamWriter writer, ContactType contact) throws XMLStreamException {
        if (contact.getNames().size() > 0) {
            writeText(writer, "Name", contact.getNames().get(0).getLang(), contact.getNames().get(0).getText());
        }
        if (contact.getDepartments().size() > 0) {
            writeText(writer, "Department", contact.getDepartments().get(0).getLang(), contact.getDepartments().get(0).getText());
        }
        if (contact.getTelephones().size() > 0) {
            writeText(writer, "Telephone", null, contact.getTelephones().get(0));
        }
    }
}
