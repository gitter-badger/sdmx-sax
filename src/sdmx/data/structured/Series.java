/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import java.util.ArrayList;
import java.util.List;
import sdmx.data.Attachable;
import sdmx.data.AttachmentLevel;

/**
 *
 * @author James
 */
public class Series implements Attachable {
    private List<Object> columnValues = new ArrayList<Object>();
    private StructuredColumnMapper columnMapper = null;
    private int start = -1;
    private int end = -1;
    private List<Obs> observations = new ArrayList<Obs>();
    public int size() {
        return getObservations().size();
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
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
    
    public Object getValue(int row, int col) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            throw new RuntimeException("Can't access DataSet value from Series");
        }
        else if (attach == AttachmentLevel.SERIES) {
        }
        return null;
    }


    public Object getValue(int row, String col) {
        return getValue(row,columnMapper.getColumnIndex(col));
    }


    public void setValue(int row, int col, Object val) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            getColumnValues().set(columnMapper.getDataSetIndex(s), val);
            return;
        }
        if (attach == AttachmentLevel.SERIES) {
            setValue(col, val);
        }
   }

    public void setValue(int row, String col, Object val) {
        setValue(row,columnMapper.getSeriesIndex(col),val);
    }

    /**
     * @return the columnValues
     */
    public List<Object> getColumnValues() {
        return columnValues;
    }

    /**
     * @param columnValues the columnValues to set
     */
    public void setColumnValues(List<Object> columnValues) {
        this.columnValues = columnValues;
    }

    /**
     * @return the mapper
     */
    public StructuredColumnMapper getMapper() {
        return columnMapper;
    }

    /**
     * @param mapper the mapper to set
     */
    public void setMapper(StructuredColumnMapper mapper) {
        this.columnMapper = mapper;
    }

    @Override
    public Object getValue(String s) {
        return getValue(columnMapper.getSeriesIndex(s));
    }

    @Override
    public void setValue(String s, Object val) {
        if( !columnMapper.containsColumn(s)){
            columnMapper.registerColumn(s, AttachmentLevel.SERIES);
        }
        setValue(columnMapper.getSeriesIndex(s),val);
    }

    @Override
    public AttachmentLevel getAttachmentLevel() {
        return AttachmentLevel.SERIES;
    }

    @Override
    public Object getValue(int i) {
        return columnValues.get(i);
    }

    @Override
    public void setValue(int i, Object val) {
        if( columnValues.size()-1<i) {
            for(int j=columnValues.size();j-1<i;j++) {
                columnValues.add(null);
            }
        }
        columnValues.set(i, val);
    }

}
