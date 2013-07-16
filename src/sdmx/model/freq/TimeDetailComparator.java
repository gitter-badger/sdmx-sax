/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.model.freq;

import java.util.Calendar;
import java.util.Comparator;

/**
 *
 * @author James
 */
public class TimeDetailComparator implements Comparator {
    public static final TimeDetailComparator INSTANCE = new TimeDetailComparator();
    private TimeDetailComparator(){
    }

    public int compare(Object o1, Object o2) {
        TimeDetail t1 = (TimeDetail)o1;
        TimeDetail t2 = (TimeDetail)o2;
        Calendar d1 = t1.getCalendar();
        Calendar d2 = t2.getCalendar();
        if( d1 == null ) return 0;
        if( d2 == null ) return 0;
        return d1.compareTo(d2);
    }
    

}
