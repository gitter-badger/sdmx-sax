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
            /*
             * Sometimes, if a data message has optional fields, 
             * a value on an observation may not be set, so the 
             * number of values in columnValues may not properly
             * reflect the total number of fields (since there is an optional one at the end)
             * in this case some observations may have the number of optional fields less
             * elements in columnValues than an Obs with the optional field(s) set. 
             */
        if( i >= columnValues.size() ) return null;
        return columnValues.get(i);
    }
    
    
    public Object getObservationValue(int i) {
            /*
             * Sometimes, if a data message has optional fields, 
             * a value on an observation may not be set, so the 
             * number of values in columnValues may not properly
             * reflect the total number of fields (since there is an optional one at the end)
             * in this case some observations may have the number of optional fields less
             * elements in columnValues than an Obs with the optional field(s) set. 
             */
        int idx = getColumnMapper().getObservationIndex(i);
        if( idx >= columnValues.size() ) return null;
        return columnValues.get(idx);
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
