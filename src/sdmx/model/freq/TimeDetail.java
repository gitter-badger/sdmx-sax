/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.model.freq;

import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author James
 */
public interface TimeDetail extends Comparable {
    @Override
    public String toString();
    @Override
    public boolean equals(Object o);
    @Override
    public int hashCode();
    public Calendar getCalendar();
    public String getTimeFormat();
}
