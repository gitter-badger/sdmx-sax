/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import java.util.ArrayList;
import java.util.List;
import sdmx.data.AttachmentLevel;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSetWriter;
import sdmx.data.flat.FlatDataSet;
import sdmx.data.flat.FlatObs;

/**
 *
 * @author James
 */
public class StructuredDataWriter implements DataSetWriter {
    private StructuredColumnMapper mapper = new StructuredColumnMapper();
    private StructuredDataSet dataSet = null;

    private List<Series> seriesList = new ArrayList<Series>();
    private List<Obs> obsList = new ArrayList<Obs>();
    
    private Series series = null;
    private boolean in_series = false;
    private Obs obs = null;
    
    public StructuredDataWriter() {}
    public StructuredDataWriter(StructuredColumnMapper mapper) {
        this.mapper=mapper;
    }
    
    @Override
    public void newDataSet() {
        //System.out.println("New DataSet");
        dataSet = new StructuredDataSet(mapper);
    }

    @Override
    public void newSeries() {
        //System.out.println("New Series");
        series = new Series();
        in_series = true;
        series.setMapper(mapper);
    }

    @Override
    public void newObservation() {
        //System.out.println("New Obs");
        obs = new Obs();
        obs.setColumnMapper(mapper);
    }
    @Override
    public void writeDataSetComponent(String name, String val) {
        //System.out.println("DS Name:"+name+":"+val);
        dataSet.setValue(name, val);
    }

    @Override
    public void writeSeriesComponent(String name, String val) {
        //System.out.println("S Name:"+name+":"+val);
        series.setValue(name, val);
    }

    @Override
    public void writeObservationComponent(String name, String val) {
        //System.out.println("O Name:"+name+":"+val);
        obs.setValue(name, val);
    }

    @Override
    public void finishSeries() {
        seriesList.add(series);
        in_series=false;
        series = null;
    }

    @Override
    public void finishObservation() {
        if( in_series ) {
            series.getObservations().add(obs);
            obs = null;
        }else {
            obsList.add(obs);
            obs = null;
        }
    }

    @Override
    public StructuredDataSet finishDataSet() {
        StructuredDataSet ds = dataSet;
        if( seriesList.size()>0){
            ds.setSeriesList(seriesList);
        }else {
            ds.setObservations(obsList);
        }
        ds.updateIndexes();
        dataSet=null;
        return ds;
    }    

    @Override
    public ColumnMapper getColumnMapper() {
        return mapper;
    }

  
}
