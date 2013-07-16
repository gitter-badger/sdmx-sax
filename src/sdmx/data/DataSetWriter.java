/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import sdmx.data.flat.FlatDataSet;

/**
 *
 * @author James
 */
public interface DataSetWriter {
    public void newDataSet();
    public void newSeries();
    public void newObservation();
    public void writeDataSetComponent(String name,String val);
    public void writeSeriesComponent(String name,String val);
    public void writeObservationComponent(String name,String val);
    public void finishObservation();
    public void finishSeries();
    public DataSet finishDataSet();
}
