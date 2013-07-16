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
public class MonthlyTimeDetail implements TimeDetail {

    private int year = 0;
    private int month = 0;
    transient Calendar cal = null;

    public MonthlyTimeDetail(String td) {
        year = Integer.parseInt(td.substring(0,3));
        month = Integer.parseInt(td.substring(5,7));
        cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
    }

    public MonthlyTimeDetail(Integer year) {
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
        if (o1 instanceof MonthlyTimeDetail && o2 instanceof MonthlyTimeDetail) {
            MonthlyTimeDetail ad = (MonthlyTimeDetail) o1;
            MonthlyTimeDetail ad2 = (MonthlyTimeDetail) o2;
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
        if (!(o instanceof MonthlyTimeDetail)) {
            return false;
        } else {
            MonthlyTimeDetail ad = (MonthlyTimeDetail) o;
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
