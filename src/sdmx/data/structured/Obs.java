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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class Obs implements Attachable {
    private int rowId = 0;
    private StructuredColumnMapper columnMapper = null;
    List<String> columnValues = new ArrayList<>();

    @Override
    public String getValue(String s) {
        return columnValues.get(getColumnMapper().getObservationIndex(s));
    }
    
    @Override
    public void setValue(String s, String val) {
        if( !columnMapper.containsColumn(s)){
            columnMapper.registerColumn(s, AttachmentLevel.OBSERVATION);
        }
        setValue(getColumnMapper().getObservationIndex(s),val);
    }

    @Override
    public String getValue(int i) {
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
    
    
    public String getObservationValue(int i) {
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
    public void setValue(int i, String val) {
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
