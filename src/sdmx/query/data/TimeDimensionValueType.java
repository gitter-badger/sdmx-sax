/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import sdmx.query.base.TimeValue;

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
    
}