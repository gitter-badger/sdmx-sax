/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero.generic;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
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
import sdmx.common.Name;
import sdmx.commonreferences.IDType;
import sdmx.data.DataSet;
import sdmx.data.DataSetWriter;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.SenderType;
import sdmx.version.twopointzero.Sdmx20EventHandler;
import sdmx.version.twopointzero.compact.CompactDataEventHandler;
import static sdmx.version.twopointzero.compact.CompactDataEventHandler.STATE_HEADER;
import static sdmx.version.twopointzero.compact.CompactDataEventHandler.STATE_HEADERPREPARED;
import sdmx.workspace.Registry;
import sdmx.xml.DateTime;
import sdmx.xml.DateType;

/**
 *
 * @author James
 */
public class GenericDataEventHandler extends Sdmx20EventHandler {
    
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
    public static final int STATE_KEYFAMILYREF = 10;
    public static final int STATE_KEYFAMILYREFEND = 11;
    public static final int STATE_DATASETEND = 12;
    public static final int STATE_SERIES = 13;
    public static final int STATE_SERIESEND = 14;
    public static final int STATE_OBS = 15;
    public static final int STATE_OBSEND = 16;
    public static final int STATE_FINISH = 17;
    public static final int STATE_GROUP = 18;
    public static final int STATE_GROUPEND = 19;
    public static final int STATE_GROUPKEY = 20;
    public static final int STATE_SERIESKEY = 21;
    public static final int STATE_GROUPATTRIBUTES = 22;
    public static final int STATE_SERIESATTRIBUTES = 23;
    public static final int STATE_OBSATTRIBUTES = 24;
    public static final int STATE_TIME = 25;
    public static final int STATE_DATASETATTRIBUTES = 26;
    
    BaseHeaderType header = new BaseHeaderType();
    List<DataSet> datasets = new ArrayList<DataSet>();
    String crossSection = null;
    public int state = -1;
    private String freq = null;
    private boolean in_group = false;
    private boolean in_series = false;
    DataSetWriter writer = new FlatDataSetWriter();

    public GenericDataEventHandler() {
    }
    public GenericDataEventHandler(DataSetWriter writer) {
        this.writer=writer;
    }

    public DataMessage getDataMessage() {
        if (state != STATE_FINISH) {
            throw new RuntimeException("You can't get the document before i've finished parsing!");
        }
        DataMessage dm = new DataMessage();
        dm.setDataSets(datasets);
        dm.setHeader(header);
        return dm;
    }

    public void startRootElement(Attributes atts) {
        if (state != -1) {
            throw new RuntimeException("State not -1");
        }
        state = STATE_START;
        /*
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
                            this.docStruct = new GenericDataStructureDocument(in);
                        } catch (JAXBException ex) {
                            System.out.println("JAXBException reading MSD");
                        } catch (IOException io) {
                            System.out.println("IOException reading MSD");
                        }
                    }
                }
            }
        }
        */
    }

    public void startHeader() {
        state = STATE_HEADER;
    }

    public void startHeaderID() {
        state = STATE_HEADERID;
    }

    public void endHeaderID() {
    }

    public void startHeaderTest() {
        state = STATE_HEADERTEST;
    }

    public void endHeaderTest() {
    }

    public void startHeaderTruncated() {
        state = STATE_HEADERTRUNCATED;
    }

    public void endHeaderTruncated() {
    }

    public void startHeaderPrepared() {
        state = STATE_HEADERPREPARED;
    }

    public void endHeaderPrepared() {
    }

    public void startHeaderSender(Attributes atts) {
        state = STATE_HEADERSENDER;
        SenderType s = new SenderType();
        s.setId(new IDType(atts.getValue("id")));
        header.setSender(s);
    }

    public void endHeaderSender() {
    }

    public void endHeader() {
        state = STATE_HEADEREND;
        // Insert witty assertions here
    }

    public void startDataSet(String uri, Attributes atts) {
        state = STATE_DATASET;
        writer.newDataSet();

    }
    public void startKeyFamilyRef(String ui,Attributes atts) {
        state= STATE_KEYFAMILYREF;
    }
    public void endKeyFamilyRef() {
        state=STATE_KEYFAMILYREFEND;
    }
    public void startGroup(String uri, Attributes atts) {
        state = STATE_GROUP;
        in_group = true;
    }

    public void startSeries(String uri, Attributes atts) {
        state = STATE_SERIES;
        in_series = true;
        writer.newSeries();
    }

    public void startObs(String uri, Attributes atts) {
        state = STATE_OBS;
        writer.newObservation();
    }

    public void endObs() throws SAXException {
        state = STATE_OBSEND;
        writer.finishObservation();
    }

    public void endSeries() {
        if (state != STATE_OBSEND) {
            throw new RuntimeException("SeriesEnd does not follow Series");
        }
        state = STATE_SERIESEND;
        writer.finishSeries();
        in_series = false;
    }

    public void endGroup() {
        state = STATE_GROUPEND;
        in_group = false;
    }

    public void endDataSet() {
        state = STATE_DATASETEND;
        datasets.add(writer.finishDataSet());
    }

    public void endRootElement() {
        state = STATE_FINISH;
    }

    public void startName() {
        state = STATE_HEADERNAME;
    }

    public void endName() {
    }

    public void characters(char[] c) {
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
                // This field is in sdmx 2.0 but not in 2.1 ignore
                //header.setTruncated(Boolean.parseBoolean(new String(c)));
                this.state = STATE_HEADER;
                break;
            case STATE_HEADERPREPARED:
                HeaderTimeType htt = new HeaderTimeType();
                htt.setDate(DateTime.fromString(new String(c)));
                header.setPrepared(htt);
                this.state = STATE_HEADER;
                break;
            case STATE_HEADERNAME:
                Name name = new Name(null,new String(c));
                List<Name> names = header.getNames();
                if( names == null ) names = new ArrayList<Name>();
                names.add(name);
                header.setNames(names);
                this.state = STATE_HEADER;
                break;
            case STATE_TIME:
                writer.writeObservationComponent("TIME", new String(c));
                break;
            case STATE_KEYFAMILYREF:
                //dsheader.setKeyFamilyURI(new String(c));
                break;
        }
    }

    void startValue(String uri, Attributes atts) {
        //System.out.println("startvalue:concept:" + atts.getValue("concept"));
        //System.out.println("startvalue:value:" + atts.getValue("value"));
        switch (state) {
            case STATE_GROUPKEY:
                break;
            case STATE_GROUPATTRIBUTES:
                break;
            case STATE_SERIESKEY:
                writer.writeSeriesComponent(atts.getValue("concept"), atts.getValue("value"));
                break;
            case STATE_SERIESATTRIBUTES:
                writer.writeSeriesComponent(atts.getValue("concept"), atts.getValue("value"));
                break;
            case STATE_OBSATTRIBUTES:
                writer.writeObservationComponent(atts.getValue("concept"), atts.getValue("value"));
                break;
            case STATE_DATASETATTRIBUTES:
                writer.writeDataSetComponent(atts.getValue("concept"), atts.getValue("value"));
                break;
        }

    }

    void startTime(String uri, Attributes atts) {
        //System.out.println("stime");
        state=STATE_TIME;
    }

    void startAttributes(String uri, Attributes atts) {
        //System.out.println("startattributes");
        switch (state) {
            case STATE_GROUPKEY:
                state = STATE_GROUPATTRIBUTES;break;
            case STATE_GROUP:
                state = STATE_GROUPATTRIBUTES;break;
            case STATE_SERIESKEY:
                state = STATE_SERIESATTRIBUTES;break;
            case STATE_SERIES:
                state = STATE_SERIESATTRIBUTES;break;
            case STATE_OBS:
                state = STATE_OBSATTRIBUTES;break;
            case STATE_DATASET:
                state = STATE_DATASETATTRIBUTES;break;
        }
    }

    void startSeriesKey(String uri, Attributes atts) {
        //System.out.println("startserieskey");
        state = STATE_SERIESKEY;
    }

    void startGroupKey(String uri, Attributes atts) {
        //System.out.println("startgroupkey");
        state = STATE_GROUPKEY;
    }

    void startObsValue(String uri, Attributes atts) {
        //System.out.println("startobsvalue:" + atts.getValue("value"));
        writer.writeObservationComponent("OBS_VALUE", atts.getValue("value"));
    }

    void endValue() {
        //System.out.println("endvalue");
    }

    void endTime() {
        state=STATE_OBS;

    }

    void endAttributes() {
        //System.out.println("endattributes");
    }

    void endSeriesKey() {
        //System.out.println("endserieskey");
    }

    void endGroupKey() {
        //System.out.println("endgroupkey");
    }

    void endObsValue() {
        //System.out.println("endobsvalue");
    }
}
