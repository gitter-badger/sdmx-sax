/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import java.util.ArrayList;
import java.util.List;
import sdmx.data.Attachable;
import sdmx.data.AttachmentLevel;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSet;
import sdmx.data.DataSetWriter;

/**
 *
 * @author James
 */
public class StructuredDataSet implements DataSet,Attachable {
    List<Object> columnValues = new ArrayList<Object>();

    private List<Series> series = new ArrayList<Series>();
    private List<Obs> observations = new ArrayList<Obs>();
    
    private StructuredColumnMapper columnMapper = new StructuredColumnMapper();

    public StructuredColumnMapper getColumnMapper() {
        return columnMapper;
    }

    public Series getSeries(int i) {
        return series.get(i);
    }

    @Override
    public void dump() {
        for (int i = 0; i < columnMapper.size(); i++) {
            System.out.print(columnMapper.getAttachmentLevel(i).getName()+":"+columnMapper.getColumnName(i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < columnMapper.size(); j++) {
                Object o = getValue(i, j);
                if (o == null) {
                    System.out.print("null\t");
                } else {
                    String c = o.getClass().getSimpleName();
                    System.out.print(o.toString() + ":" + c + "\t");
                }
                //System.out.print(getValue(i,j)+"\t");
            }
            System.out.println();
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnMapper.getColumnName(i);
    }

    @Override
    public int getColumnSize() {
        return columnMapper.size();
    }

    @Override
    public int size() {
        int result = 0;
        for (int i = 0; i < series.size(); i++) {
            result += series.get(i).size();
        }
        return result;
    }

    @Override
    public Object getValue(int row, int col) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            return columnValues.get(columnMapper.getDataSetIndex(s));
        }
        else if (attach == AttachmentLevel.SERIES) {
            Series series = findSeries(row);
            return series.getValue(columnMapper.getSeriesIndex(s));
        }
        else if (attach == AttachmentLevel.OBSERVATION) {
            Series series = findSeries(row);
            //System.out.println("Find Row:"+row+": Series="+series);
            //System.out.println("Find Row:"+row+": Obs="+series.getObservationRow(row));
            return series.getObservationRow(row).getValue(columnMapper.getObservationIndex(s));
        }
        else return null;
    }

    @Override
    public Object getValue(int row, String col) {
        return getValue(row,columnMapper.getColumnIndex(col));
    }

    @Override
    public void setValue(int row, int col, Object val) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            columnValues.set(columnMapper.getDataSetIndex(s), val);
            return;
        }
        if (attach == AttachmentLevel.SERIES) {
            Series series = findSeries(row);
            series.setValue(columnMapper.getSeriesIndex(s), val);
        }
        if (attach == AttachmentLevel.OBSERVATION) {
            Series series = findSeries(row);
            Obs obs = series.getObservationRow(row);
            obs.setValue(columnMapper.getObservationIndex(s), val);
        }
   }

    @Override
    public void setValue(int row, String col, Object val) {
    }

    @Override
    public void writeTo(DataSetWriter writer) {
    }
    

    public AttachmentLevel getAttachmentLevel() {
        return AttachmentLevel.DATASET;
    }

    public Series findSeries(int row) {
        return series.get(findSeriesIndex(row));
    }

    public int findSeriesIndex(int row) {
        return findSeriesIndex(row, 0, series.size());
    }

    public int findSeriesIndex(int row, int from, int to) {
        //System.out.println("Find Row:"+row+": from:"+from+" to"+to);
        for(int i=from;i<to;i++) {
            if( series.get(i).contains(row)) {
                return i;
            }
        }
        System.out.println("Can't Find");
        return -1;
    }

    @Override
    public Object getValue(String s) {
        return getValue(columnMapper.getDataSetIndex(s));
    }

    @Override
    public void setValue(String s, Object val) {
        if( !columnMapper.containsColumn(s)){
            columnMapper.registerColumn(s, AttachmentLevel.DATASET);
        }
        setValue(columnMapper.getDataSetIndex(s),val);
    }

    @Override
    public Object getValue(int i) {
        return columnValues.get(i);
    }

    @Override
    public void setValue(int i, Object val) {
        if( columnValues.size()<i) {
            for(int j=columnValues.size();j<i;j++) {
                columnValues.add(null);
            }
        }
        columnValues.set(i, val);
    }
    public void updateIndexes() {
        int start = 0;
        int end = 0;
        for(Series s:series){
            s.updateIndexes(start);
            end = end+s.size();
            s.setEnd(end);
            start=end;
            //s.dump();
        }
    }

    /**
     * @return the series
     */
    public List<Series> getSeriesList() {
        return series;
    }

    /**
     * @param series the series to set
     */
    public void setSeriesList(List<Series> series) {
        this.series = series;
    }

    /**
     * @return the observations
     */
    public List<Obs> getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(List<Obs> observations) {
        this.observations = observations;
    }
}
