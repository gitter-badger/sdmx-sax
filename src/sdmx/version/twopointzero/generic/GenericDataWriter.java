/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readsdmx.sdmx20.generic;

/**
 *
 * @author James
 */
import readsdmx.sdmx20.compact.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import readsdmx.model.immutable.DataSet;
import readsdmx.model.immutable.DataDocument;
import readsdmx.model.immutable.Group;
import readsdmx.model.immutable.Observation;
import readsdmx.model.immutable.Series;
import readsdmx.model.component.AttributeComponent;
import readsdmx.model.component.Component;
import readsdmx.model.component.DimensionComponent;
import readsdmx.model.component.PrimaryMeasureComponent;
import readsdmx.model.component.TimeDimensionComponent;
import readsdmx.model.meta.MetaAttribute;
import readsdmx.model.meta.MetaDimension;
import readsdmx.model.meta.MetaPrimaryMeasure;
import readsdmx.model.meta.MetaStructure;
import readsdmx.model.meta.MetaTimeDimension;

public class GenericDataWriter {

    public static void write(DataDocument dsd, Namespace name, OutputStream out) {
        //setup this like outputDocument
        if (dsd.isTimeSeries() && !dsd.isCrossSection()) {
            try {
                XMLOutputter outputter = new XMLOutputter();
                //output to a file
                OutputStreamWriter writer = new OutputStreamWriter(out);
                outputter.output(createDocument(dsd, name), writer);
                writer.close();
            } catch (java.io.IOException e) {
                e.printStackTrace();
            }
        }else {
            throw new RuntimeException("CompactData cannot save a cross sectional data!");
        }
    }

    /**
    
     */
    public static Document createDocument(DataDocument doc, Namespace namespace) {
        MetaStructure struct = doc.getDataSet().getMetaStructure();
        // Create the root element
        Element compactData = new Element("GenericData");
        compactData.setNamespace(Namespace.getNamespace("message", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message"));
        compactData.addNamespaceDeclaration(Namespace.getNamespace("common", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/common"));
        compactData.addNamespaceDeclaration(Namespace.getNamespace("compact", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/compact"));
        compactData.addNamespaceDeclaration(Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance"));
        compactData.addNamespaceDeclaration(Namespace.getNamespace("schemaLocation", "http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message http://www.sdmx.org/docs/2_0/SDMXMessage.xsd"));
        Element header = new Element("Header");
        if (doc.getId() != null && !"".equals(doc.getId())) {
            Element id = new Element("ID");
            id.addContent(doc.getId());
            header.addContent(id);
        }
        if (doc.getTest() != null && !"".equals(doc.getTest())) {
            Element test = new Element("Test");
            test.addContent(doc.getTest().toString());
            header.addContent(test);
        }
        if (doc.getName() != null && !"".equals(doc.getName())) {
            Element name = new Element("Name");
            name.addContent(doc.getName());
            header.addContent(name);
        }
        if (doc.getPrepared() != null && !"".equals(doc.getPrepared())) {
            Element prep = new Element("Prepared");
            prep.addContent(doc.getPrepared());
            header.addContent(prep);
        }
        if (doc.getTruncated() != null && !"".equals(doc.getTruncated())) {
            Element trunc = new Element("Truncated");
            trunc.addContent(doc.getTruncated().toString());
            header.addContent(trunc);
        }

        if (doc.getSenderId() != null && !"".equals(doc.getSenderId())) {
            Element send = new Element("Sender");
            send.setAttribute("id", doc.getSenderId());
            header.addContent(send);
        }
        compactData.addContent(header);
        Element dataSet = new Element("DataSet");
        dataSet.setNamespace(namespace);
        DataSet ds = doc.getDataSet();
        if (ds.getAction() != null && !"".equals(ds.getAction())) {
            dataSet.setAttribute("Action", ds.getAction());
        }
        if (ds.getDataFlowAgencyID() != null && !"".equals(ds.getDataFlowAgencyID())) {
            dataSet.setAttribute("DataFlowAgencyID", ds.getDataFlowAgencyID());
        }
        if (ds.getDataFlowID() != null) {
            dataSet.setAttribute("DataFlowID", ds.getDataFlowID());
        }
        if (ds.getDataProviderID() != null) {
            dataSet.setAttribute("DataProviderID", ds.getDataProviderID());
        }
        if (ds.getDataProviderSchemeAgencyId() != null) {
            dataSet.setAttribute("DataProviderSchemeAgencyId", ds.getDataProviderSchemeAgencyId());
        }
        if (ds.getDataProviderSchemeId() != null) {
            dataSet.setAttribute("DataProviderSchemeId", ds.getDataProviderSchemeId());
        }
        if (ds.getDataSetID() != null) {
            dataSet.setAttribute("DataSetID", ds.getDataSetID());
        }
        if (ds.getKeyFamilyURI() != null) {
            dataSet.setAttribute("KeyFamilyURI", ds.getKeyFamilyURI());
        }
        if (ds.getPublicationPeriod() != null) {
            dataSet.setAttribute("PublicationPeriod", ds.getPublicationPeriod());
        }
        if (ds.getPublicationYear() != null) {
            dataSet.setAttribute("PublicationYear", ds.getPublicationYear());
        }
        
        for (int i = 0; i < ds.getGroupSize(); i++) {
            Group g = ds.getGroup(i);
            Element ge = new Element("Group");
// Ignore Groups for now
        }
        for (int i = 0; i < ds.getSeriesSize(); i++) {
            Series s = ds.getSeries(i);
            Element se = new Element("Series");
            se.setNamespace(namespace);
            List<MetaDimension> list = struct.getDimensions();
            for (int j = 0; j < list.size(); j++) {
                MetaDimension dt = list.get(j);
                DimensionComponent dc = s.getDimensionComponent(dt.getConceptRef());
                if (dc != null) {
                    se.setAttribute(dt.getConceptRef(), dc.getStringValue());
                }
            }
            List<MetaAttribute> alist = struct.getAttributes();
            for (int j = 0; j < alist.size(); j++) {
                MetaAttribute dt = alist.get(j);
                AttributeComponent ac = s.getAttribute(dt.getConceptRef());
                if (ac != null) {
                    se.setAttribute(dt.getConceptRef(), ac.getStringValue());
                }
            }
            List<MetaTimeDimension> tlist = struct.getTimeDimensions();
            for (int j = 0; j < tlist.size(); j++) {
                MetaTimeDimension mtd = tlist.get(j);
                TimeDimensionComponent tdc = s.getTimeDimension(mtd.getConceptRef());
                if (tdc != null) {
                    se.setAttribute(mtd.getConceptRef(), tdc.getStringValue());
                }
            }
            Iterator<Observation> it2 = s.getObservations().iterator();
            while (it2.hasNext()) {
                Element obs = getElement(struct, it2.next());
                obs.setNamespace(namespace);
                se.addContent(obs);
            }
            dataSet.addContent(se);
        }
        compactData.addContent(dataSet);
        Document myDocument = new Document();
        myDocument.addContent(compactData);
        return myDocument;
    }

    public static Element getElement(MetaStructure struct, Observation o) {
        String type = o.getCrossSection() != null ? o.getCrossSection() : "Obs";
        Element obs = new Element(type);
        MetaPrimaryMeasure mpm = struct.getPrimaryMeasure();
        PrimaryMeasureComponent measure = o.getPrimaryMeasure();
        obs.setAttribute(mpm.getConceptRef(), measure.getStringValue());

        Iterator<MetaTimeDimension> tdt = struct.getTimeDimensions().iterator();
        while (tdt.hasNext()) {
            MetaTimeDimension mtd = tdt.next();
            TimeDimensionComponent tdc = o.getTimeDimension(mtd.getConceptRef());
            if (tdc.getAttachLevel() == Component.ATTACH_OBSERVATION) {
                obs.setAttribute(mtd.getConceptRef(), tdc.getStringValue());
            }
        }
        List<MetaAttribute> list2 = struct.getAttributes();
        for (int k = 0; k < list2.size(); k++) {
            MetaAttribute at = list2.get(k);
            AttributeComponent ac = o.getAttributeComponent(at.getConceptRef());
            if (ac != null && ac.getAttachLevel() == Component.ATTACH_OBSERVATION) {
                obs.setAttribute(at.getConceptRef(), ac.getStringValue());
            }
        }
        return obs;
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
}
