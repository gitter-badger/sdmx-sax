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
    int rowId = 0;
    StructuredColumnMapper columnMapper = null;
    List<Object> columnValues = new ArrayList<>();

    @Override
    public Object getValue(String s) {
        return columnValues.get(columnMapper.getObservationIndex(s));
    }
    
    @Override
    public void setValue(String s, Object val) {
        setValue(columnMapper.getObservationIndex(s),val);
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

    @Override
    public AttachmentLevel getAttachmentLevel() {
        return AttachmentLevel.OBSERVATION;
    }
}
