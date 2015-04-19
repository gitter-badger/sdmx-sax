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

/**
 *
 * @author James
 */
public class SDMXJSONWriter implements DataSetWriter {
    Registry registry = null;
    DataStructureReference dsref = null;
    private DataStructureType struct = null;
    HashMap<String,List<CodeType>> map = new HashMap<String,List<CodeType>>();
    
    public SDMXJSONWriter(Registry reg,DataStructureReference ref){
        this.registry=reg;
        this.dsref=ref;
        this.struct = reg.find(ref);
    }
    
    @Override
    public ColumnMapper getColumnMapper() {
        return null;
    }

    @Override
    public void newDataSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newSeries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void newObservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeDataSetComponent(String name, String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeSeriesComponent(String name, String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeObservationComponent(String name, String val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeGroupValues(String name, HashMap<String, Object> group) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finishObservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void finishSeries() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataSet finishDataSet() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
