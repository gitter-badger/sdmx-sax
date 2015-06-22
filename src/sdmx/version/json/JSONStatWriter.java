/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.json;

/**
 *
 * @author James
 */
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import sdmx.version.twopointzero.writer.*;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import sdmx.Registry;
import sdmx.common.Name;
import sdmx.cube.Cube;
import sdmx.cube.CubeObservation;
import sdmx.data.DataSet;
import sdmx.data.Group;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.structureddata.ValueTypeResolver;
import sdmx.data.structured.Obs;
import sdmx.data.structured.Series;
import sdmx.data.structured.StructuredColumnMapper;
import sdmx.data.structured.StructuredDataSet;
import sdmx.message.*;
import sdmx.structure.base.NameableType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.structure.datastructure.TimeDimensionType;
import static sdmx.version.twopointzero.writer.GenericDataWriter.writeName;
import net.hamnaberg.jsonstat.util.IntCartesianProduct;
import sdmx.structure.datastructure.MeasureDimensionType;
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class JSONStatWriter {

    public static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd");

    public static void write(DataMessage message, DataflowType flow, Registry reg, Locale loc, OutputStream out) throws XMLStreamException, IOException {
        System.out.println("Write!");
        JsonWriter writer = null;
        writer = new JsonWriter(new OutputStreamWriter(out));
        try {
            writer.beginObject();
            writeJSONStatMessage(message, flow, reg, loc, writer);
            writer.endObject();
        } catch (IOException ex) {
            Logger.getLogger(StreamingSdmxJSONWriter.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } finally {
            writer.close();
        }
        System.out.println("Finished Writing");
    }

    /**
     *
     */
    public static void writeJSONStatMessage(DataMessage msg, DataflowType flow, Registry reg, Locale loc, JsonWriter writer) throws XMLStreamException, IOException {
        DataStructureType struct = reg.find(flow.getStructure());
        writer.name(NameableType.toIDString(flow)).beginObject();
        writer.name("label").value(NameableType.toString(flow, loc));
        writer.name("source").value(NameableType.toString(msg.getHeader().getSender(), loc));
        writer.name("updated").value(DF.format(msg.getHeader().getPrepared().getDate().getDate()));
        writer.name("extension").beginObject();
        if (msg.getHeader().getSender().getContacts().size() > 0) {
            writer.name("contact").value(msg.getHeader().getSender().getContacts().get(0).getEmails().get(0));
            writer.name("metadata").beginArray();
            writer.endArray();
        }
        writer.endObject();
        Cube cube = new Cube(struct);
        msg.getDataSets().get(0).query(cube, null);
        Integer value_size = 1;
        for (int i = 0; i < struct.getDataStructureComponents().getDimensionList().getDimensions().size(); i++) {
            value_size *= cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getDimensions().get(i).getId().toString()).size();
        }
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null){
        value_size *= cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString()).size();
        }
        if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null) {
            value_size *= cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString()).size();
        }
        boolean value_labels = false;
        //System.out.println("Cube Size=" + cube.getSize());
        //System.out.println("Value Size=" + value_size);
        
        int[] lengths = new int[struct.getDataStructureComponents().getDimensionList().size()+(struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null?1:0)+(struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null?1:0)];
        for(int i=0;i<struct.getDataStructureComponents().getDimensionList().size();i++) {
            lengths[i]=cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getDimension(i).getId().toString()).size();
        }
        int timeDimensionIndex = lengths.length-1-(struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null?1:0);
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null){
            lengths[timeDimensionIndex]=cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString()).size();
        }
        int measureDimensionIndex = lengths.length-1;
        if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null) {
            lengths[lengths.length-1]=cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString()).size();
        }
        IntCartesianProduct cartesianProduct = new IntCartesianProduct(lengths);
        int[] result = null;
        
        if (cube.getSize() < (value_size / 2)) {
            value_labels = true;
        }
        if (!value_labels) {
            writer.name("value").beginArray();
            for (int i = 1; i <= value_size; i++) {
                writeValue(i,cartesianProduct.next(), cube, flow, reg, value_labels, writer);
            }
            writer.endArray();
        } else {
            writer.name("value").beginObject();
            for (int i = 1; i <= value_size; i++) {
                writeValue(i,cartesianProduct.next(), cube, flow, reg, value_labels, writer);
            }
            writer.endObject();
        }
        writer.name("status").beginArray().endArray();
        writer.name("dimension").beginObject();
        writer.name("id").beginArray();
        for(int i=0;i<struct.getDataStructureComponents().getDimensionList().size();i++){
            writer.value(struct.getDataStructureComponents().getDimensionList().getDimension(i).getId().toString());
        }
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null) {
            writer.value(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString());
        }
        writer.endArray();
        writer.name("size").beginArray();
        for(int i=0;i<struct.getDataStructureComponents().getDimensionList().size();i++){
            writer.value(cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getDimension(i).getId().toString()).size());
        }
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null) {
            writer.value(cube.getValidCodes(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString()).size());
        }
        writer.endArray();
        writer.name("role").beginObject();
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null){
            writer.name("time").beginArray().value(struct.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString()).endArray();
        }
        if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null){
            writer.name("concept").beginArray().value(struct.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString()).endArray();
        }
        writer.endObject();//role
        
        for(int i=0;i<struct.getDataStructureComponents().getDimensionList().size();i++){
            DimensionType dim = struct.getDataStructureComponents().getDimensionList().getDimension(i);
            writer.name(dim.getId().toString()).beginObject();
            writer.name("label").value(NameableType.toString(reg.find(dim.getConceptIdentity()),loc));
            writer.name("category").beginObject();
            writer.name("index").beginArray();
            int index =0;
            for(String s:cube.getValidCodes(dim.getId().toString())){
                writer.value(s);
            }
            writer.endArray();
            writer.name("label").beginObject();
            for(String s:cube.getValidCodes(dim.getId().toString())){
                writer.name(s).value(NameableType.toString(ValueTypeResolver.resolveCode(reg, struct, dim.getId().toString(), s),loc));
            }
            writer.endObject();
            //writer.name("unit").beginObject();
            //writer.endObject();
                    
            writer.endObject();
            writer.endObject();
        }
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null) {
            TimeDimensionType dim = struct.getDataStructureComponents().getDimensionList().getTimeDimension();
            writer.name(dim.getId().toString()).beginObject();
            writer.name("label").value(NameableType.toString(reg.find(dim.getConceptIdentity()),loc));
            writer.name("category").beginObject();
            writer.name("index").beginObject();
            int index =0;
            for(String s:cube.getValidCodes(dim.getId().toString())){
                writer.name(s).value(index++);
            }
            writer.endObject();
            //writer.name("label").beginObject();
            //for(String s:cube.getValidCodes(dim.getId().toString())){
            //    writer.name(s).value(s);
            //}
            //writer.endObject();
            //writer.name("unit").beginObject();
            //writer.endObject();
                    
            writer.endObject();
            writer.endObject();
        }
        if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null) {
            MeasureDimensionType dim = struct.getDataStructureComponents().getDimensionList().getMeasureDimension();
            writer.name(dim.getId().toString()).beginObject();
            writer.name("label").value(NameableType.toString(reg.find(dim.getConceptIdentity()),loc));
            writer.name("category").beginObject();
            writer.name("index").beginArray();
            int index =0;
            for(String s:cube.getValidCodes(dim.getId().toString())){
                writer.value(s);
            }
            writer.endArray();
            writer.name("label").beginObject();
            for(String s:cube.getValidCodes(dim.getId().toString())){
                writer.name(s).value(NameableType.toString(ValueTypeResolver.resolveCode(reg, struct, dim.getId().toString(), s),loc));
            }
            writer.endObject();
            //writer.name("unit").beginObject();
            //writer.endObject();
                    
            writer.endObject();//Category
            writer.endObject();// Dimension
        }
        
        writer.endObject(); //Dimension
        writer.endObject(); //Document
    }

    public static void writeValue(int index,int[] result, Cube cube, DataflowType flow, Registry reg, boolean labels, JsonWriter writer) throws IOException {
        CubeObservation obs = null;
        try {
            obs = cube.find(toFullKey(result, flow, reg, cube));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        //if( obs == null ) {
        //    toFullKey(result, flow, reg, cube).dump();
        //}
        if (!labels) {
            if (obs == null) {
                writer.nullValue();
            } else {
                writer.value(Double.parseDouble(obs.getValue()));
            }
        } else {
            if (obs == null) {
            } else {
                writer.name(String.valueOf(index)).value(Double.parseDouble(obs.getValue()));
            }
        }
    }

    public static FullKey toFullKey(int[] result, DataflowType flow, Registry reg, Cube cube) {
        DataStructureType struct = reg.find(flow.getStructure());
        LinkedHashMap<String,Object> key = new LinkedHashMap<String,Object>();
        int i=0;
        for (;i<struct.getDataStructureComponents().getDimensionList().size(); i++) {
            DimensionType dim = struct.getDataStructureComponents().getDimensionList().getDimension(i);
            key.put(dim.getId().toString(), cube.getValidCodes(dim.getId().toString()).get(result[i]));
        }
        if( struct.getDataStructureComponents().getDimensionList().getTimeDimension()!=null) {
            TimeDimensionType td = struct.getDataStructureComponents().getDimensionList().getTimeDimension();
            key.put(td.getId().toString(), cube.getValidCodes(td.getId().toString()).get(result[i++]));
        }
        if( struct.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null) {
            MeasureDimensionType md = struct.getDataStructureComponents().getDimensionList().getMeasureDimension();
            key.put(md.getId().toString(), cube.getValidCodes(md.getId().toString()).get(result[i++]));
        }
        return new FullKey(key);
    }

}
