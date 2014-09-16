/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero.writer;

/**
 *
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
import sdmx.structureddata.ValueTypeResolver;
import sdmx.data.structured.Obs;
import sdmx.data.structured.Series;
import sdmx.data.structured.StructuredColumnMapper;
import sdmx.data.structured.StructuredDataSet;
import sdmx.message.*;

public class GenericDataWriter {

    public static void write(DataMessage message, OutputStream out) throws XMLStreamException {
        //setup this like outputDocument
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(out);
        //output to a file
        writeDataMessage(message, writer);
        writer.close();
    }

    /**
     *
     */
    public static void writeDataMessage(DataMessage msg, XMLStreamWriter writer) throws XMLStreamException {
        // Create the root element
        String namespace = msg.getNamespace();
        String namespaceprefix = msg.getNamespacePrefix();
        writer.writeStartDocument();
        writer.writeStartElement("GenericData");
        writer.writeDefaultNamespace("http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        writer.writeNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message");
        writer.writeNamespace("common", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/common");
        writer.writeNamespace("compact", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/compact");
        writer.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
        writer.writeNamespace("schemaLocation", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message http://www.sdmx.org/docs/2_0/SDMXMessage.xsd");
        writer.writeNamespace(namespaceprefix, namespace);
        writer.writeStartElement("Header");
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
            for (int i = 0; i < msg.getHeader().getNames().size(); i++) {
                writer.writeStartElement("Name");
                writer.writeAttribute("xml:lang", msg.getHeader().getNames().get(i).getLang());
                writer.writeCharacters(msg.getHeader().getNames().get(i).getText());
                writer.writeEndElement();
            }
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
            writer.writeAttribute("id", msg.getHeader().getSender().getId().toString());
            if (msg.getHeader().getSender().getContacts() != null && msg.getHeader().getSender().getContacts().size() > 0) {
                writeContact(writer, msg.getHeader().getSender().getContacts().get(0));
            }
            writer.writeEndElement();
        }
        if (msg.getHeader().getReceivers() != null && msg.getHeader().getReceivers().size() > 0) {
            writer.writeStartElement("Receiver");
            writer.writeAttribute("id", msg.getHeader().getReceivers().get(0).getId().toString());
            if (msg.getHeader().getReceivers().get(0).getContacts() != null && msg.getHeader().getReceivers().get(0).getContacts().size() > 0) {
                writeContact(writer, msg.getHeader().getReceivers().get(0).getContacts().get(0));
            }
            writer.writeEndElement();
        }
        if (msg.getHeader().getDataSetAction() != null && !"".equals(msg.getHeader().getDataSetAction())) {
            writer.writeStartElement("DataSetAction");
            writer.writeCharacters(msg.getHeader().getDataSetAction().getString());
            writer.writeEndElement();
        }
        if (msg.getHeader().getExtracted() != null) {
            writer.writeStartElement("Extracted");
            writer.writeCharacters(msg.getHeader().getExtracted().toString());
            writer.writeEndElement();
        }
        if (msg.getHeader().getReportingBegin() != null) {
            writer.writeStartElement("ReportingBegin");
            writer.writeCharacters(msg.getHeader().getReportingBegin().toString());
            writer.writeEndElement();
        }
        if (msg.getHeader().getReportingEnd() != null) {
            writer.writeStartElement("ReportingEnd");
            writer.writeCharacters(msg.getHeader().getReportingEnd().toString());
            writer.writeEndElement();
        }
        writer.writeEndElement();
        writer.writeStartElement(namespaceprefix, "DataSet", namespace);

        DataSet ds = msg.getDataSets().get(0);

        if (msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider().getAgencyId() != null) {
            writer.writeAttribute("DataFlowAgencyID", msg.getHeader().getDataProvider().getAgencyId().toString());
        }
        if (msg.getHeader().getDataSetID() != null && msg.getHeader().getDataSetID().size() > 0) {
            writer.writeAttribute("DataFlowID", msg.getHeader().getDataSetID().get(0).toString());
        }
        if (msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider().getAgencyId() != null) {
            writer.writeAttribute("DataProviderID", msg.getHeader().getDataProvider().getAgencyId().toString());
        }
        if (msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider().getAgencyId() != null) {
            writer.writeAttribute("DataProviderSchemeAgencyId", msg.getHeader().getDataProvider().getAgencyId().toString());
        }
        if (msg.getHeader().getDataProvider() != null && msg.getHeader().getDataProvider().getRef() != null && msg.getHeader().getDataProvider().getAgencyId() != null) {
            writer.writeAttribute("DataProviderSchemeId", msg.getHeader().getDataProvider().getId().toString());
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
                writer.writeStartElement(namespaceprefix, "Series", namespace);
                Series s = sds.getSeriesList().get(i);
                for (int j = 0; j < mapper.size(); j++) {
                    if (mapper.isAttachedToSeries(j)) {
                        writer.writeAttribute(mapper.getColumnName(j), s.getValue(j));
                    }
                }
                for (int k = 0; k < s.getObservations().size(); k++) {
                    writer.writeEmptyElement(namespaceprefix, "Obs", namespace);
                    Obs o = s.getObservations().get(k);
                    for (int j = 0; j < mapper.size(); j++) {
                        if (mapper.isAttachedToObservation(j)) {
                            writer.writeAttribute(mapper.getColumnName(j), o.getObservationValue(j));
                        }
                    }
                    writer.writeEndElement();
                }
                writer.writeEndElement();
            }
        }
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
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
