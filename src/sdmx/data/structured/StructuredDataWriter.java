/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import java.util.ArrayList;
import java.util.List;
import sdmx.data.AttachmentLevel;
import sdmx.data.DataSetWriter;
import sdmx.data.flat.FlatDataSet;
import sdmx.data.flat.FlatObs;

/**
 *
 * @author James
 */
public class StructuredDataWriter implements DataSetWriter {
    
    private StructuredDataSet dataSet = null;

    private List<Series> seriesList = new ArrayList<Series>();
    private List<Obs> obsList = new ArrayList<Obs>();
    
    private Series series = null;
    private boolean in_series = false;
    private Obs obs = null;
    
    @Override
    public void newDataSet() {
        dataSet = new StructuredDataSet();
    }

    @Override
    public void newSeries() {
        series = new Series();
        in_series = true;
        series.setMapper(dataSet.getColumnMapper());
    }

    @Override
    public void newObservation() {
        obs = new Obs();
        obs.setColumnMapper(dataSet.getColumnMapper());
    }

    @Override
    public void writeDataSetComponent(String name, String val) {
        dataSet.setValue(name, val);
    }

    @Override
    public void writeSeriesComponent(String name, String val) {
        series.setValue(name, val);
    }

    @Override
    public void writeObservationComponent(String name, String val) {
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
        dataSet=null;
        return ds;
    }    
    
}
