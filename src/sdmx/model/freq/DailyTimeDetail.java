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
public class DailyTimeDetail implements TimeDetail {

    private int year = 0;
    transient Calendar cal = null;

    public DailyTimeDetail(String td) {
        year = Integer.parseInt(td);
        cal = Calendar.getInstance();
        cal.set(year, 1, 1);
    }

    public DailyTimeDetail(Integer year) {
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
        if (o1 instanceof DailyTimeDetail && o2 instanceof DailyTimeDetail) {
            DailyTimeDetail ad = (DailyTimeDetail) o1;
            DailyTimeDetail ad2 = (DailyTimeDetail) o2;
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
        if (!(o instanceof DailyTimeDetail)) {
            return false;
        } else {
            DailyTimeDetail ad = (DailyTimeDetail) o;
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
