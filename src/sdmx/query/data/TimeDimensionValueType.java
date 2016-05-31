/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import sdmx.commonreferences.NestedNCNameID;
import sdmx.query.base.TimeValue;
import sdmx.structure.datastructure.TimeDimensionType;

/**
 *
 * @author James
 */

public class TimeDimensionValueType {

    private TimeValue start = null;
    private TimeValue end = null;
    public TimeDimensionValueType(TimeValue start, TimeValue end) {
        this.start=start;
        this.end=end;
    }

   public NestedNCNameID getId() {
     return TimeDimensionType.ID;
   }
    
    /**
     * @return the start
     */
    public TimeValue getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(TimeValue start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public TimeValue getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(TimeValue end) {
        this.end = end;
    }
    public boolean match(String s) {
// Ignore for now
        return true;
    }
    
}
