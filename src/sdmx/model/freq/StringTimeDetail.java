/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.freq;

import java.util.Calendar;

/**
 *
 * @author James
 */
public class StringTimeDetail implements TimeDetail {

    private String time = null;

    public StringTimeDetail(String td) {
        time=td;
    }

    public int compareTo(Object o2) {
        Object o1 = this;
        if (o1 instanceof StringTimeDetail && o2 instanceof StringTimeDetail) {
            StringTimeDetail ad = (StringTimeDetail) o1;
            StringTimeDetail ad2 = (StringTimeDetail) o2;
            return ad.time.compareTo(ad2.time);
        } else {
            System.out.println("o1=" + o1);
            System.out.println("o2=" + o2);
            throw new RuntimeException("Not A Time Detail");
        }
    }

    public String toString() {
        return "StringTimeDetail:"+time;
    }

    public int hashCode() {
        return time.hashCode();
    }

    public boolean equals(Object o) {
        if (!(o instanceof StringTimeDetail)) {
            return false;
        } else {
            StringTimeDetail ad = (StringTimeDetail) o;
            return time.equals(ad.time);
        }

    }
    public Calendar getCalendar() {
       return null;
    }
    public String getTimeFormat() { return "Unknown"; }

}
