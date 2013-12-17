/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.List;

/**
 *
 * @author James
 */
public interface ColumnMapper {
    public int registerColumn(String s,AttachmentLevel attach);
    public int getColumnIndex(String s);
    public String getColumnName(int i);
    public int size();
    public boolean containsColumn(String name);
    public List<String> getAllColumns();
    public List<String> getObservationColumns();
    public List<String> getSeriesColumns();
    public List<String> getDataSetColumns();
    public List<String> getGroupColumns();
    public boolean isAttachedToDataSet(String s);
    public boolean isAttachedToDataSet(int i);
    public boolean isAttachedToSeries(String s);
    public boolean isAttachedToSeries(int i);
    public boolean isAttachedToObservation(String s);
    public boolean isAttachedToObservation(int i);
    public boolean isAttachedToGroup(String s);
    public boolean isAttachedToGroup(int i);
    public void dump();
    
}
