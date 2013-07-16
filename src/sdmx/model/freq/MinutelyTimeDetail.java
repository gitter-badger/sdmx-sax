/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.freq;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author James
 */
public class MinutelyTimeDetail implements TimeDetail {

    private int year = 0;
    transient Calendar cal = null;

    public MinutelyTimeDetail(String td) {
        year = Integer.parseInt(td);
        cal = Calendar.getInstance();
        cal.set(year, 1, 1);
    }

    public MinutelyTimeDetail(Integer year) {
        this.year = year;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    public int compareTo(Object o2) {
        Object o1 = this;
        if (o1 instanceof MinutelyTimeDetail && o2 instanceof MinutelyTimeDetail) {
            MinutelyTimeDetail ad = (MinutelyTimeDetail) o1;
            MinutelyTimeDetail ad2 = (MinutelyTimeDetail) o2;
            return ad.getYear() - ad2.getYear();
        } else {
            System.out.println("o1=" + o1);
            System.out.println("o2=" + o2);
            throw new RuntimeException("Not A Time Detail");
        }
    }

    public String toString() {
        return Integer.toString(year);
    }

    public int hashCode() {
        return Integer.toString(year).hashCode();
    }

    public boolean equals(Object o) {
        if (!(o instanceof MinutelyTimeDetail)) {
            return false;
        } else {
            MinutelyTimeDetail ad = (MinutelyTimeDetail) o;
            return year == ad.getYear();
        }

    }

    public Calendar getCalendar() {
        return cal;
    }

    public String getTimeFormat() {
        return "P1Y";
    }
}
