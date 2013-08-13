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
public class Obs implements Attachable {
    private int rowId = 0;
    private StructuredColumnMapper columnMapper = null;
    List<Object> columnValues = new ArrayList<>();

    @Override
    public Object getValue(String s) {
        return columnValues.get(getColumnMapper().getObservationIndex(s));
    }
    
    @Override
    public void setValue(String s, Object val) {
        if( !columnMapper.containsColumn(s)){
            columnMapper.registerColumn(s, AttachmentLevel.OBSERVATION);
        }
        setValue(getColumnMapper().getObservationIndex(s),val);
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

    @Override
    public AttachmentLevel getAttachmentLevel() {
        return AttachmentLevel.OBSERVATION;
    }

    /**
     * @return the columnMapper
     */
    public StructuredColumnMapper getColumnMapper() {
        return columnMapper;
    }

    /**
     * @param columnMapper the columnMapper to set
     */
    public void setColumnMapper(StructuredColumnMapper columnMapper) {
        this.columnMapper = columnMapper;
    }

    /**
     * @return the rowId
     */
    public int getRowId() {
        return rowId;
    }

    /**
     * @param rowId the rowId to set
     */
    public void setRowId(int rowId) {
        this.rowId = rowId;
    }
}
