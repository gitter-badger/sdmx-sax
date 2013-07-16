/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointone.structspec;

import readsdmx.sdmx21.structspec.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import sdmx.common.ObservationDimensionType;
import sdmx.common.PayloadStructureType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureRefType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.data.flat.FlatDataSet;
import sdmx.data.flat.FlatObs;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.SenderType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.twopointzero.compact.CompactDataEventHandler;
import static sdmx.version.twopointzero.compact.CompactDataEventHandler.STATE_HEADER;
import sdmx.workspace.Registry;
import sdmx.xml.DateType;
import sdmx.xml.ID;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class StructSpecEventHandler {

    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    public static final int STATE_START = 0;
    public static final int STATE_HEADER = 1;
    public static final int STATE_HEADERID = 2;
    public static final int STATE_HEADERTEST = 3;
    public static final int STATE_HEADERTRUNCATED = 4;
    public static final int STATE_HEADERPREPARED = 5;
    public static final int STATE_HEADERSENDER = 6;
    public static final int STATE_HEADERNAME = 7;
    public static final int STATE_HEADEREND = 8;
    public static final int STATE_DATASET = 9;
    public static final int STATE_DATASETEND = 10;
    public static final int STATE_SERIES = 11;
    public static final int STATE_SERIESEND = 12;
    public static final int STATE_OBS = 13;
    public static final int STATE_OBSEND = 14;
    public static final int STATE_FINISH = 15;
    public static final int STATE_GROUP = 16;
    public static final int STATE_GROUPEND = 17;
    public static final int STATE_STRUCTURE = 18;
    public static final int STATE_STRUCTUREEND = 19;
    public static final int STATE_COMMONSTRUCTURE = 20;
    public static final int STATE_COMMONSTRUCTUREEND = 21;
    public static final int STATE_REF = 22;
    public static final int STATE_REFEND = 23;

    BaseHeaderType header = new BaseHeaderType();
    List<PayloadStructureType> payloads = new ArrayList<PayloadStructureType>();
    PayloadStructureType payload = null;

    List<FlatDataSet> datasets = new ArrayList<FlatDataSet>();
    FlatDataSet dataSet = null;

    String crossSection = null;
    public int state = -1;
    private String freq = null;
    private boolean in_group = false;
    private boolean in_series = false;
    
    private Registry registry = null;
    
    DataStructureType dataStructure = null;
    

    public StructSpecEventHandler() {
    }

    public StructSpecEventHandler(Registry registry) {
        this.registry=registry;
    }

    public DataMessage getDataMessage() {
        return null;
    }

    public void startRootElement(Attributes atts) throws SAXException, PropertyVetoException {
        if (state != -1) {
            throw new SAXException();
        }
        state = STATE_START;
        if (atts.getValue("xsi:schemaLocation") != null || atts.getValue("schemaLocation") != null) {
            // ABS Data has this, UIS Does Not
            //throw new SAXException("Root Element does not have schema location!");
            /*
            if (atts.getValue("xsi:schemaLocation") != null) {
                header.setSchemaLocation(atts.getValue("xsi:schemaLocation"));
            }
            if (atts.getValue("schemaLocation") != null) {
                header.setSchemaLocation(atts.getValue("schemaLocation"));
            }*/
        }

    }

    public void startHeader() throws SAXException {
        state = STATE_HEADER;
    }

    public void startHeaderID() throws SAXException {
        state = STATE_HEADERID;
    }

    public void endHeaderID() {
    }

    public void startHeaderTest() throws SAXException {
        state = STATE_HEADERTEST;
    }

    public void endHeaderTest() {
    }

    public void startHeaderTruncated() throws SAXException {
        state = STATE_HEADERTRUNCATED;
    }

    public void endHeaderTruncated() {
    }

    public void startHeaderPrepared() throws SAXException {
        state = STATE_HEADERPREPARED;
    }

    public void endHeaderPrepared() {
    }

    public void startHeaderSender(Attributes atts) {
        state = STATE_HEADERSENDER;
        SenderType sender = new SenderType();
        sender.setId(new IDType(atts.getValue("ID")));
        header.setSender(sender);
    }

    public void endHeaderSender() {
    }

    void startStructure(Attributes atts) throws URISyntaxException {
        state = STATE_STRUCTURE;
        PayloadStructureType payload = new PayloadStructureType();
        payload.setStructureID(new ID(atts.getValue("structureID")));
        payload.setDimensionAtObservation(new ObservationDimensionType(atts.getValue("dimensionAtObservation")));
        payload.setNamespace(new anyURI(atts.getValue("namespace")));
        this.payload=payload;
    }

    public void endStructure() {
        state = STATE_STRUCTUREEND;
        payloads.add(payload);
    }

    void startCommonStructure(Attributes atts) {
        state = STATE_COMMONSTRUCTURE;
    }

    void endCommonStructure() {
        state = STATE_COMMONSTRUCTUREEND;
    }

    void endRef() {
        state = STATE_REFEND;
    }

    void startRef(Attributes atts) {
        state = STATE_REF;
        StructureRefType srt = new StructureRefType(ObjectTypeCodelistType.DATASTRUCTURE,PackageTypeCodelistType.DATASTRUCTURE);
        srt.setAgencyId(new NestedNCNameIDType(atts.getValue("agencyID")));
        srt.setId(new NestedIDType(atts.getValue("id")));
        srt.setVersion(new VersionType(atts.getValue("version")));
        payload.setStructure(new StructureReferenceType(srt,null));
    }

    public void endHeader() {
        state = STATE_HEADEREND;
        // Insert witty assertions here
    }

    public void startDataSet(String uri, Attributes atts) {
        state = STATE_DATASET;
        dsheader.setStructureRef(atts.getValue("data:structureRef"));
        dsheader.setType(atts.getValue("xsi:type"));
        dsheader.setDataScope(atts.getValue("data:dataScope"));
        struct = docStruct.createMetaStructure(header.getRefId(), header.getAgencyId(), header.getVersion());
    }

    public void startGroup(String uri, Attributes atts) throws SAXException {
        state = STATE_GROUP;
        in_group = true;
        if (atts.getValue("FREQ") != null) {
            freq = atts.getValue("FREQ");
        }
        Iterator<MetaDimension> it = struct.getDimensions().iterator();
        while (it.hasNext()) {
            MetaDimension dim = it.next();
            String dimId = dim.getConceptRef();
            Component c = dim.createGroupComponent(atts.getValue(dimId));
            if (c != null) {
                groupComps.add(c);
            }
        }
        Iterator<MetaAttribute> it2 = struct.getAttributes().iterator();
        while (it2.hasNext()) {
            MetaAttribute at = it2.next();
            String dimId = at.getConceptRef();
            Component c = at.createGroupComponent(atts.getValue(dimId));
            if (c != null) {
                groupComps.add(c);
            }
        }
    }

    public void startSeries(String uri, Attributes atts) throws SAXException {
        state = STATE_SERIES;
        in_series = true;
        if (atts.getValue("FREQ") != null) {
            freq = atts.getValue("FREQ");
        }
        Iterator<MetaDimension> it = struct.getDimensions().iterator();
        while (it.hasNext()) {
            MetaDimension dim = it.next();
            String dimId = dim.getConceptRef();
            if (atts.getValue(dimId) != null) {
                Component c = dim.createSeriesComponent(atts.getValue(dimId));
                seriesComps.add(c);
            }
        }
        Iterator<MetaAttribute> it2 = struct.getAttributes().iterator();
        while (it2.hasNext()) {
            MetaAttribute at = it2.next();
            String dimId = at.getConceptRef();
            if (atts.getValue(dimId) != null) {
                Component c = at.createSeriesComponent(atts.getValue(dimId));
                seriesComps.add(c);
            }
        }
        Iterator<MetaTimeDimension> it3 = struct.getTimeDimensions().iterator();
        while (it3.hasNext()) {
            MetaTimeDimension mtd = it3.next();
            String tdimId = mtd.getConceptRef();
            if (atts.getValue(tdimId) != null) {
                Component c = mtd.createSeriesComponent(atts.getValue(tdimId), freq);
                seriesComps.add(c);
            }
        }

    }

    public void startObs(String uri, Attributes atts) throws SAXException {
        if (state != STATE_SERIES && state != STATE_OBSEND && state != STATE_DATASET) {
            throw new RuntimeException("Obs does not follow series, or obsend");
        }
        state = STATE_OBS;
        if (atts.getValue("FREQ") != null) {
            freq = atts.getValue("FREQ");
        }
        Iterator<MetaDimension> it = struct.getDimensions().iterator();
        while (it.hasNext()) {
            MetaDimension dim = it.next();
            String dimId = dim.getConceptRef();
            if (atts.getValue(dimId) != null) {
                Component c = dim.createSeriesComponent(atts.getValue(dimId));
                obsComps.add(c);
            }
        }
        Iterator<MetaAttribute> it2 = struct.getAttributes().iterator();
        while (it2.hasNext()) {
            MetaAttribute at = it2.next();
            String dimId = at.getConceptRef();
            if (atts.getValue(dimId) != null) {
                Component c = at.createSeriesComponent(atts.getValue(dimId));
                obsComps.add(c);
            }
        }
        MetaPrimaryMeasure mpm = struct.getPrimaryMeasure();
        String pdimId = mpm.getConceptRef();
        if (atts.getValue(pdimId) != null) {
            Component c = mpm.createObservationComponent(atts.getValue(pdimId));
            if (c != null) {
                obsComps.add(c);
            } else {
                System.out.println("No Primary Measure!!??");
                obsComps.add(mpm.createObservationComponent("0"));
            }
        }
        Iterator<MetaTimeDimension> it3 = struct.getTimeDimensions().iterator();
        while (it3.hasNext()) {
            MetaTimeDimension mtd = it3.next();
            String tdimId = mtd.getConceptRef();
            if (atts.getValue(tdimId) != null) {
                Component c = mtd.createObservationComponent(atts.getValue(tdimId), freq);
                obsComps.add(c);
            }
        }
        Iterator<MetaCrossSection> it4 = struct.getCrossSections().iterator();
        while (it4.hasNext()) {
            MetaCrossSection mcs = it4.next();
            if (atts.getValue("xsi:type") != null) {
                String type = atts.getValue("xsi:type").substring(atts.getValue("xsi:type").indexOf(":")+1, atts.getValue("xsi:type").length());
                if (mcs.getName().equals(type)) {
                    Component mc = mcs.createObservationComponent(type);
                    crossSection = mc.getStringValue();
                    obsComps.add(mc);
                    System.out.println("ConceptRef="+mc.getConceptRef()+" Val="+mc.getStringValue());
                }
            }
        }
    }

    public void endObs() throws SAXException {
        if (state != STATE_OBS) {
            throw new RuntimeException("ObsEnd does not follow Obs");
        }
        state = STATE_OBSEND;
        KeySet ks = null;
        if (in_group && !in_series) {
            ks = KeyUtil.createPartialKey(groupComps);
            groupObsList.add(factory.createObservation(ks, obsComps, crossSection));

        }
        if (in_group && in_series) {
            ks = KeyUtil.createPartialKey(groupComps);
            ks = ks.concat(KeyUtil.createPartialKey(seriesComps));
            seriesObsList.add(factory.createObservation(ks, obsComps, crossSection));
        }
        if (in_series && !in_group) {
            ks = KeyUtil.createPartialKey(seriesComps);
            seriesObsList.add(factory.createObservation(ks, obsComps, crossSection));
        }
        if (!in_series && !in_group) {
            dsObsList.add(factory.createObservation(null, obsComps, crossSection));
        }
        obsComps.clear();
        crossSection = null;
    }

    public void endSeries() throws SAXException {
        if (state != STATE_OBSEND) {
            throw new RuntimeException("SeriesEnd does not follow Series");
        }
        state = STATE_SERIESEND;
        if (in_group) {
            groupSeriesList.add(factory.createSeries(seriesComps, seriesObsList));
        } else {
            dsSeriesList.add(factory.createSeries(seriesComps, seriesObsList));
        }
        seriesComps.clear();
        seriesObsList.clear();
        in_series = false;
    }

    public void endGroup() throws SAXException {
        state = STATE_GROUPEND;
        dsGroupList.add(factory.createGroup(null, groupComps, groupSeriesList));
        groupComps.clear();
        groupSeriesList.clear();
        in_group = false;
    }

    public void endDataSet() {
        state = STATE_DATASETEND;
        datasets.add(factory.createDataSet(dsheader, dsGroupList, dsSeriesList, dsObsList, struct));
        dsGroupList.clear();
        dsSeriesList.clear();
        dsObsList.clear();
    }

    public void endRootElement() throws SAXException, PropertyVetoException {
        state = STATE_FINISH;
    }

    public void startName() {
        state = STATE_HEADERNAME;
    }

    public void endName() {
    }

    public void characters(char[] c) throws PropertyVetoException {
        //System.out.println("Characters:" + new String(c));
        switch (state) {
            case STATE_HEADERID:
                header.setId(new String(c));
                break;
            case STATE_HEADERTEST:
                header.setTest(Boolean.parseBoolean(new String(c)));
                break;
            case STATE_HEADERPREPARED:
                HeaderTimeType htt = new HeaderTimeType();
                Calendar cal = Calendar.getInstance();
                try {
                    cal.setTime(df.parse(new String(c)));
                } catch (ParseException ex) {
                    try {
                        cal.setTime(df2.parse(new String(c)));


                    } catch (ParseException ex2) {
                        Logger.getLogger(StructSpecEventHandler.class
                                .getName()).log(Level.SEVERE, null, ex2);
                    }
                }

                htt.setDate(new DateType(cal));
                header.setPrepared(htt);
                this.state = STATE_HEADER;
                break;
        }
    }
}
