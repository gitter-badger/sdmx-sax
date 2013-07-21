/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.twopointzero.compact;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBException;
import org.apache.xmlbeans.XmlObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import sdmx.common.DataType;
import sdmx.common.Name;
import sdmx.common.PayloadStructureType;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.data.DataSet;
import sdmx.data.DataSetWriter;
import sdmx.data.flat.FlatDataSet;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.data.flat.FlatObs;
import sdmx.message.BaseHeaderType;
import sdmx.message.DataMessage;
import sdmx.message.HeaderTimeType;
import sdmx.message.PartyType;
import sdmx.message.SenderType;
import sdmx.message.StructureType;
import sdmx.structure.base.RepresentationType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.datastructure.AttributeListType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.DataStructureComponents;
import sdmx.structure.datastructure.DimensionListType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.MeasureListType;
import sdmx.version.twopointzero.Sdmx20EventHandler;
import sdmx.structure.base.Component;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.workspace.LocalRegistry;
import sdmx.workspace.Registry;
import sdmx.xml.DateTime;
import sdmx.xml.DateType;
import sdmx.xml.ID;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class CompactDataEventHandler extends Sdmx20EventHandler {


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
    //StructureType struct = null;
    private BaseHeaderType header = new BaseHeaderType();
    private List<PayloadStructureType> payloads = new ArrayList<PayloadStructureType>();
    public int state = -1;
    private String freq = null;
    private boolean in_group = false;
    private boolean in_series = false;
    DataSetWriter writer = new FlatDataSetWriter();
    
    DataStructureType keyFamily = null;
    
    public CompactDataEventHandler() {
    }

    public DataMessage getDataMessage() {
        if (state != STATE_FINISH) {
            throw new RuntimeException("You can't get the document before i've finished parsing!");
        }
        DataMessage doc = new DataMessage();
        doc.setHeader(header);
        ArrayList<DataSet> dataSets = new ArrayList<DataSet>();
        dataSets.add(writer.finishDataSet());
        doc.setDataSets(dataSets);
        return doc;
    }

    public void startRootElement(Attributes atts) {
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
             }
             */
        }

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
        SenderType sender = new SenderType();
        sender.setId(new IDType(atts.getValue("id")));
        header.setSender(sender);
    }

    public void endHeaderSender() {
    }

    public void endHeader() {
        state = STATE_HEADEREND;
        // Insert witty assertions here
    }

    public void startDataSet(String uri, Attributes atts) throws URISyntaxException {
        state = STATE_DATASET;
        PayloadStructureType payload = new PayloadStructureType();
        if (atts.getValue("keyFamilyURI") != null) {
            payload.setStructureURL(new anyURI(atts.getValue("keyFamilyURI")));
        }
        payload.setStructureID(new ID("STR1"));
        /*
        if( keyFamily==null ) {
            NestedNCNameIDType agency = new NestedNCNameIDType(atts.getValue("agencyID"));
            IDType id = new IDType(atts.getValue("id"));
            init(registry.findDataStructure(agency, id));
        }*/
        for(int i=0;i<atts.getLength();i++) {
            String name = atts.getLocalName(i);
            String val = atts.getValue(i);
            writer.writeDataSetComponent(name, val);
        }
        payloads.add(payload);
        writer.newDataSet();
    }

    public void startGroup(String uri, Attributes atts) {
        state = STATE_GROUP;
        in_group = true;
    }

    public void startSeries(String uri, Attributes atts) {
        state = STATE_SERIES;
        in_series = true;
        writer.newSeries();
        for(int i=0;i<atts.getLength();i++) {
            String name = atts.getLocalName(i);
            String val = atts.getValue(i);
            writer.writeSeriesComponent(name, val);
        }
    }

    public void startObs(String uri, Attributes atts) {
        if (state != STATE_SERIES && state != STATE_OBSEND) {
            throw new RuntimeException("Obs does not follow series, or obsend");
        }
        state = STATE_OBS;
        writer.newObservation();
        for(int i=0;i<atts.getLength();i++) {
            String name = atts.getLocalName(i);
            String val = atts.getValue(i);
            writer.writeObservationComponent(name, val);
        }
    }

    public void endObs() {
        if (state != STATE_OBS) {
            throw new RuntimeException("ObsEnd does not follow Obs");
        }
        state = STATE_OBSEND;
        writer.finishObservation();
        //System.out.println("Obs=" + Arrays.toString(obsValues.toArray()));
    }

    public void endSeries() {
        if (state != STATE_OBSEND&&state!=STATE_SERIES) {
            throw new RuntimeException("SeriesEnd does not follow Series State="+state);
        }
        state = STATE_SERIESEND;
        in_series = false;
        writer.finishSeries();
    }

    public void endGroup() {
        state = STATE_GROUPEND;
        in_group = false;
    }

    public void endDataSet() {
        if (state != STATE_SERIESEND) {
            throw new RuntimeException("DataSet does not Series End!");
        }
        state = STATE_DATASETEND;
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
                // No Truncated in SDMX 2.1
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
                List<Name> names = new ArrayList<Name>();
                Name name = new Name(null, new String(c));
                names.add(name);
                header.setNames(names);
                this.state = STATE_HEADER;
                break;
        }
    }
}