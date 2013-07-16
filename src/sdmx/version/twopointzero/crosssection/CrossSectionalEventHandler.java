/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package readsdmx.sdmx20.crosssection;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import javax.xml.bind.JAXBException;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import readsdmx.model.DocumentFactory;
import readsdmx.model.DocumentHeader;
import readsdmx.model.immutable.DataSet;
import readsdmx.model.DataSetHeader;
import readsdmx.model.component.Component;
import readsdmx.model.immutable.DataDocument;
import readsdmx.model.immutable.Group;
import readsdmx.model.immutable.Observation;
import readsdmx.model.immutable.Series;
import readsdmx.model.key.KeySet;
import readsdmx.model.key.KeyUtil;
import readsdmx.model.meta.MetaAttribute;
import readsdmx.model.meta.MetaCodelist;
import readsdmx.model.meta.MetaCrossSection;
import readsdmx.model.meta.MetaDimension;
import readsdmx.model.meta.MetaPrimaryMeasure;
import readsdmx.model.meta.MetaStructure;
import readsdmx.model.meta.MetaTimeDimension;
import readsdmx.sdmx20.Sdmx20EventHandler;
import readsdmx.sdmx20.Sdmx20MetaDocumentStructure;
import readsdmx.sdmx20.compact.CompactDataStructureDocument;

/**
 *
 * @author James
 */
public class CrossSectionalEventHandler extends Sdmx20EventHandler {

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
    DocumentHeader header = new DocumentHeader();
    List<DataSet> datasets = new ArrayList<DataSet>();
    DataSetHeader dsheader = new DataSetHeader();
    DataSet dataSet = null;
    List<Observation> dsObsList = new ArrayList<Observation>();
    List<Series> dsSeriesList = new ArrayList<Series>();
    List<Group> dsGroupList = new ArrayList<Group>();
    Series series = null;
    List<Component> seriesComps = new ArrayList<Component>();
    List<Observation> seriesObsList = new ArrayList<Observation>();
    Group group = null;
    List<Component> groupComps = new ArrayList<Component>();
    List<Observation> groupObsList = new ArrayList<Observation>();
    List<Series> groupSeriesList = new ArrayList<Series>();
    Observation observation = null;
    List<Component> obsComps = new ArrayList<Component>();
    String crossSection = null;
    public int state = -1;
    private String freq = null;
    private DocumentFactory factory = null;
    private Sdmx20MetaDocumentStructure docStruct = null;
    private MetaStructure struct = null;
    private boolean in_group = false;
    private boolean in_series = false;

    public CrossSectionalEventHandler() {
        header.setTimeSeries(false);
        header.setCrossSectional(true);
    }

    public CrossSectionalEventHandler(DocumentFactory factory, Sdmx20MetaDocumentStructure docStruct) {
        this();
        this.factory = factory;
        this.docStruct = docStruct;
    }

    public DataDocument getDocument() {
        return factory.createDataStructureDocument(header, datasets, docStruct);
    }

    public void startRootElement(Attributes atts)  {
        state = STATE_START;
        if (atts.getValue("xsi:schemaLocation") != null || atts.getValue("schemaLocation") != null) {
            // ABS Data has this, UIS Does Not
            //throw new SAXException("Root Element does not have schema location!");
            if (atts.getValue("xsi:schemaLocation") != null) {
                header.setSchemaLocation(atts.getValue("xsi:schemaLocation"));
            }
            if (atts.getValue("schemaLocation") != null) {
                header.setSchemaLocation(atts.getValue("schemaLocation"));
            }
            if (docStruct == null) {
                StringTokenizer st = new StringTokenizer(header.getSchemaLocation());
                while (st.hasMoreTokens()) {
                    String tk = st.nextToken();
                    if (!"http://www.SDMX.org/resources/SDMXML/schemas/v2_0/message".equals(tk)
                            && !"http://www.sdmx.org/docs/2_0/SDMXMessage.xsd".equals(tk)) {
                        try {
                            URL url = new URL(tk);
                            InputStream in = url.openStream();
                            this.docStruct = new CompactDataStructureDocument(in);
                        } catch (JAXBException ex) {
                            System.out.println("JAXBException reading MSD");
                        } catch (IOException io) {
                            System.out.println("IOException reading MSD");
                        }
                    }
                }
            }
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

    public void startHeaderSender(Attributes atts) throws SAXException, PropertyVetoException {
        state = STATE_HEADERSENDER;
        header.setSenderId(atts.getValue("id"));
    }

    public void endHeaderSender() {
    }

    public void endHeader() {
        state = STATE_HEADEREND;
        // Insert witty assertions here
    }

    public void startDataSet(String uri, Attributes atts) throws PropertyVetoException, SAXException {
        state = STATE_DATASET;
        dsheader.setKeyFamilyURI(atts.getValue("keyFamilyURI"));
        struct = docStruct.getMetaStructure(dsheader.getKeyFamilyURI());
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
        Iterator<MetaTimeDimension> it3 = struct.getTimeDimensions().iterator();
        while (it3.hasNext()) {
            MetaTimeDimension mtd = it3.next();
            String tdimId = mtd.getConceptRef();
            if (atts.getValue(tdimId) != null) {
                Component c = mtd.createObservationComponent(atts.getValue(tdimId), freq);
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
                Component c = mtd.createObservationComponent(atts.getValue(tdimId), freq);
                seriesComps.add(c);
            }
        }
    }

    public void startObs(String uri, Attributes atts) throws SAXException {
        if (state != STATE_SERIES && state != STATE_OBSEND) {
            throw new RuntimeException("Obs does not follow series, or obsend");
        }
        state = STATE_OBS;
        if (atts.getValue("FREQ") != null) {
            freq = atts.getValue("FREQ");
        }
        Iterator<MetaCrossSection> it4 = struct.getCrossSections().iterator();
        while(it4.hasNext()) {
            MetaCrossSection mcs = it4.next();
            if( uri.equals(mcs.getConceptRef()) ){
                crossSection=mcs.getConceptRef();
                obsComps.add(mcs.createObservationComponent(uri));
            }
            
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
        ks=null;
        obsComps.clear();
        crossSection=null;
    }

    public void endSeries() throws SAXException {
        state = STATE_SERIESEND;
        System.out.println("InGroup+"+in_group);
        if (in_group) {
            groupSeriesList.add(factory.createSeries(seriesComps, seriesObsList));
            System.out.println("GroupSeriesList="+groupSeriesList.size());
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

    public void endRootElement() {
        state = STATE_FINISH;
    }

    public void startName() {
        state = STATE_HEADERNAME;
    }

    public void endName() {
    }

    public void characters(char[] c) throws PropertyVetoException {
        switch (state) {
            case STATE_HEADERID:
                header.setId(new String(c));
                this.state = STATE_HEADER;
                break;
            case STATE_HEADERTEST:
                header.setTest(Boolean.parseBoolean(new String(c)));
                this.state = STATE_HEADER;
                break;
            case STATE_HEADERTRUNCATED:
                header.setTruncated(Boolean.parseBoolean(new String(c)));
                this.state = STATE_HEADER;
                break;
            case STATE_HEADERPREPARED:
                header.setPrepared(new String(c));
                this.state = STATE_HEADER;
                break;
            case STATE_HEADERNAME:
                header.setName(new String(c));
                this.state = STATE_HEADER;
                break;
        }
    }

    public List<String> getGroupNames() {
        List<String> groups = new ArrayList();
        Iterator<MetaCrossSection> it = struct.getCrossSections().iterator();
        while (it.hasNext()) {
            MetaCrossSection mcs = it.next();
            groups.add(mcs.getConceptRef());
        }
        return groups;
    }
}
