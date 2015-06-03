/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.json;

import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.DataStructureReference;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSet;
import sdmx.data.DataSetWriter;
import sdmx.message.DataStructure;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.datastructure.DataStructureType;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.stream.JsonWriter;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.footer.FooterType;
import sdmx.message.BaseHeaderType;
import sdmx.message.ContactType;
import sdmx.message.PartyType;
import sdmx.structure.base.NameableType;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.xml.anyURI;

/**
 *
 * @author James
 */
public class StreamingJSONWriter implements ParseDataCallbackHandler, DataSetWriter {

    public static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    Registry registry = null;
    DataStructureReference dsref = null;
    private DataStructureType struct = null;
    HashMap<String, List<String>> dataSetValues = new HashMap<String, List<String>>();
    HashMap<String, List<String>> seriesValues = new HashMap<String, List<String>>();
    HashMap<String, List<String>> obsValues = new HashMap<String, List<String>>();
    private String dimensionAtObservation = null;
    private Locale locale = Locale.ENGLISH;
    private String requestURI = "";

    JsonWriter writer = null;

    private boolean has_series = false;
    private boolean in_series = false;
    private boolean written_series = true;
    private boolean written_series_header = false;

    List<Integer> dsKey = new ArrayList<Integer>();
    List<Integer> seriesKey = new ArrayList<Integer>();
    List<Integer> seriesAttsKey = new ArrayList<Integer>();
    List<Integer> obsKey = new ArrayList<Integer>();

    public StreamingJSONWriter(OutputStream out, Registry reg, DataStructureReference ref) {
        this.registry = reg;
        this.dsref = ref;
        this.struct = reg.find(ref);
        writer = new JsonWriter(new OutputStreamWriter(out));
        try {
            writer.beginObject();
        } catch (IOException ex) {
            Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void newDataSet() {
        try {
            writer.beginObject();
            writer.name("action").value("Information");
        } catch (IOException ex) {
            Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void newSeries() {
        has_series = true;
        seriesKey.clear();
        if(!written_series_header) {
            try {
                writer.name("series").beginObject();
            } catch (IOException ex) {
                Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            written_series_header=true;
        }
        if (!written_series) {
            try {
                writer.name(toKeyString(seriesKey)).beginObject();
            } catch (IOException ex) {
                Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            written_series=true;
        }
        written_series=false;
    }

    @Override
    public void newObservation() {
        if (has_series&&!written_series) {
            try {
                writer.name(toKeyString(seriesKey)).beginObject();
            } catch (IOException ex) {
                Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
            written_series=true;
        }
    }

    @Override
    public void writeDataSetComponent(String name, String val) {
        List<String> list = dataSetValues.get(name);
        if (list == null) {
            list = new ArrayList<String>();
            dataSetValues.put(name, list);
        }
        dsKey.add(register(list, val));
    }

    @Override
    public void writeSeriesComponent(String name, String val) {
        System.out.println("Name="+name+ "val="+val);
        List<String> list = seriesValues.get(name);
        if (list == null) {
            list = new ArrayList<String>();
            seriesValues.put(name, list);
        }
        seriesKey.add(register(list, val));
    }

    @Override
    public void writeObservationComponent(String name, String val) {
        List<String> list = obsValues.get(name);
        if (list == null) {
            list = new ArrayList<String>();
            obsValues.put(name, list);
        }
        obsKey.add(register(list, val));
    }

    @Override
    public void writeGroupValues(String name, HashMap<String, Object> group) {

    }

    @Override
    public void finishObservation() {

    }

    @Override
    public void finishSeries() {
        try {
            writer.endObject();
        } catch (IOException ex) {
            Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public DataSet finishDataSet() {
        if(written_series_header) {
            try {
                writer.endObject();
            } catch (IOException ex) {
                Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            writer.endObject(); // DataSet
        } catch (IOException ex) {
            Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void setNamespace(String prefix, String namespace) {
    }

    @Override
    public void headerParsed(BaseHeaderType header) {
        try {
            writer.name("header").beginObject();
            writer.name("id").value(header.getId());
            writer.name("prepared").value(DF.format(header.getPrepared().getDate().getDate()));
            if (header.getSender() != null) {
                writer.name("sender").beginObject();
                writer.name("id").value(header.getSender().getId().toString());
                writer.name("name").value(NameableType.toString(header.getSender(), locale));
                if (header.getSender().getContacts() != null) {
                    writer.name("contact").beginArray();
                    for (ContactType c : header.getSender().getContacts()) {
                        writer.beginObject();
                        if (c.getNames() != null) {
                            writer.name("name").value(NameableType.toString(c));
                        }
                        if (c.getDepartments() != null) {
                            writer.name("department").value(c.getDepartments().get(0).toString());
                        }
                        if (c.getRoles() != null) {
                            writer.name("role").value(c.getRoles().get(0).toString());
                        }
                        if (c.getTelephones() != null) {
                            writer.name("telephone").beginArray();
                            for (String s : c.getTelephones()) {
                                writer.value(s);
                            }
                            writer.endArray();
                        }
                        if (c.getFaxes() != null) {
                            writer.name("fax").beginArray();
                            for (String s : c.getFaxes()) {
                                writer.value(s);
                            }
                            writer.endArray();
                        }
                        if (c.getUris() != null) {
                            writer.name("uri").beginArray();
                            for (anyURI s : c.getUris()) {
                                writer.value(s.toString());
                            }
                            writer.endArray();
                        }
                        if (c.getEmails() != null) {
                            writer.name("email").beginArray();
                            for (String s : c.getEmails()) {
                                writer.value(s);
                            }
                            writer.endArray();
                        }
                        writer.endObject();
                    }
                    writer.endArray();
                }
                writer.endObject();
            }
            if (header.getReceivers() != null) {
                PartyType r = header.getReceivers().get(0);
                writer.name("receiver").beginObject();
                writer.name("id").value(header.getSender().getId().toString());
                writer.name("name").value(NameableType.toString(header.getSender(), locale));
                if (r.getContacts() != null) {
                    writer.name("contact").beginArray();
                    for (ContactType c : r.getContacts()) {
                        writer.beginObject();
                        if (c.getNames() != null) {
                            writer.name("name").value(NameableType.toString(c));
                        }
                        if (c.getDepartments() != null) {
                            writer.name("department").value(c.getDepartments().get(0).toString());
                        }
                        if (c.getRoles() != null) {
                            writer.name("role").value(c.getRoles().get(0).toString());
                        }
                        if (c.getTelephones() != null) {
                            writer.name("telephone").beginArray();
                            for (String s : c.getTelephones()) {
                                writer.value(s);
                            }
                            writer.endArray();
                        }
                        if (c.getFaxes() != null) {
                            writer.name("fax").beginArray();
                            for (String s : c.getFaxes()) {
                                writer.value(s);
                            }
                            writer.endArray();
                        }
                        if (c.getUris() != null) {
                            writer.name("uri").beginArray();
                            for (anyURI s : c.getUris()) {
                                writer.value(s.toString());
                            }
                            writer.endArray();
                        }
                        if (c.getEmails() != null) {
                            writer.name("email").beginArray();
                            for (String s : c.getEmails()) {
                                writer.value(s);
                            }
                            writer.endArray();
                        }
                        writer.endObject();
                    }
                    writer.endArray();
                }
                writer.endObject();
            }
            writer.endObject();
            writer.name("request").beginObject();
            writer.name("uri").value(requestURI);
            writer.endObject();
            writer.name("dataSets").beginArray();
        } catch (IOException ex) {
            Logger.getLogger(StreamingJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void footerParsed(FooterType footer) {

    }

    @Override
    public DataSetWriter getDataSetWriter() {
        return this;
    }

    @Override
    public void documentFinished() {
        try {
            writer.endArray();// DataSets
            writer.endObject();
            writer.flush();
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(StreamingJSONWriter.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getDimensionAtObservationHint() {
        return dimensionAtObservation;
    }

    @Override
    public void setDimensionAtObservationHint(String s
    ) {
        this.dimensionAtObservation = s;
    }

    @Override
    public void setDataStructureReferenceHint(DataStructureReference ref
    ) {
        this.dsref = ref;
    }

    @Override
    public DataStructureReference getDataStructureReferenceHint() {
        return this.dsref;
    }

    @Override
    public Registry getRegistry() {
        return this.registry;
    }

    @Override
    public void setRegistry(Registry reg
    ) {
        this.registry = reg;
    }

    private void writeHeader() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the locale
     */
    public Locale getLocale() {
        return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void setRequestURI(String s) {
        requestURI = s;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public Integer register(List<String> map, String s) {
        if (map.contains(s)) {
            return map.indexOf(s);
        } else {
            map.add(s);
            return map.indexOf(s);
        }
    }

    public String toKeyString(List<Integer> list) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(":");
            }
        }
        return sb.toString();
    }
}
