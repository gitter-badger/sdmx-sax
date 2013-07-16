/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.flat;

import java.util.ArrayList;
import java.util.List;
import sdmx.data.DataSetWriter;

/**
 *
 * @author James
 */
public class FlatDataSetWriter implements DataSetWriter {

    private FlatDataSet dataSet = null;
    private List<Object> dataSetValues = null;
    private List<Object> seriesValues = null;
    private List<Object> obsValues = null;

    @Override
    public void newDataSet() {
        dataSet = new FlatDataSet();
        dataSetValues = new ArrayList<Object>();
    }

    @Override
    public void newSeries() {
        seriesValues = new ArrayList<Object>();
        for (int i = 0; i < dataSetValues.size(); i++) {
            seriesValues.add(dataSetValues.get(i));
        }
    }

    @Override
    public void newObservation() {
        obsValues = new ArrayList<Object>();
        for (int i = 0; i < seriesValues.size(); i++) {
            obsValues.add(seriesValues.get(i));
        }

    }

    @Override
    public void writeDataSetComponent(String name, String val) {
        if (!dataSet.getColumnMapper().containsColumn(name)) {
            dataSet.registerColumn(name);
        }
        dataSetValues.add(val);
    }

    @Override
    public void writeSeriesComponent(String name, String val) {
        if (!dataSet.getColumnMapper().containsColumn(name)) {
            dataSet.registerColumn(name);
        }
        seriesValues.add(val);
    }

    @Override
    public void writeObservationComponent(String name, String val) {
        if (!dataSet.getColumnMapper().containsColumn(name)) {
            dataSet.registerColumn(name);
        }
        obsValues.add(val);
    }

    @Override
    public void finishSeries() {
        
    }

    @Override
    public void finishObservation() {
        dataSet.addObservation(new FlatObs(obsValues));
    }

    @Override
    public FlatDataSet finishDataSet() {
        FlatDataSet ds = dataSet;
        dataSet=null;
        return ds;
    }
    private void setDataSet(int i,String val) {
        if( dataSetValues.size()<i ) {
            for(int j=dataSetValues.size();j<i;j++) {
                dataSetValues.add(null);
            }
        }
        dataSetValues.set(i, val);
    }
    private void setSeries(int i,String val) {
        if( seriesValues.size()<i ) {
            for(int j=seriesValues.size();j<i;j++) {
                seriesValues.add(null);
            }
        }
        seriesValues.set(i,val);
    }
    private void setObservation(int i,String val) {
        if( obsValues.size()<i ) {
            for(int j=obsValues.size();j<i;j++) {
                obsValues.add(null);
            }
        }
        obsValues.set(i,val);
    }
}
