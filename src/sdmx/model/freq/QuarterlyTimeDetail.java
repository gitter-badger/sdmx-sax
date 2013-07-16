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
public class QuarterlyTimeDetail implements TimeDetail {

    public static final int Q1 = 1;
    public static final String END_DASH_Q1 = "-Q1";
    public static final String END_Q1 = "Q1";
    public static final int Q2 = 2;
    public static final String END_DASH_Q2 = "-Q2";
    public static final String END_Q2 = "Q2";
    public static final int Q3 = 3;
    public static final String END_DASH_Q3 = "-Q3";
    public static final String END_Q3 = "Q3";
    public static final int Q4 = 4;
    public static final String END_DASH_Q4 = "-Q4";
    public static final String END_Q4 = "Q4";

    public static final int MONTH_Q1 = 1;
    public static final int MONTH_Q2 = 4;
    public static final int MONTH_Q3 = 8;
    public static final int MONTH_Q4 = 12;


         private int year = 0;
         private int quarter = 0;
         transient Calendar cal = null;

         public QuarterlyTimeDetail(String td) {
             int month = 0;
             if( td.endsWith(END_DASH_Q1)) {
                 quarter=Q1;
                 td = td.substring(0,td.length()-END_DASH_Q1.length());
                 month = MONTH_Q1;
             }
             else if(td.endsWith(END_DASH_Q2)) {
                 quarter=Q2;
                 td = td.substring(0,td.length()-END_DASH_Q2.length());
                 month = MONTH_Q2;
             }
             else if(td.endsWith(END_DASH_Q3)) {
                 quarter=Q3;
                 td = td.substring(0,td.length()-END_DASH_Q3.length());
                 month = MONTH_Q3;
             }
             else if(td.endsWith(END_DASH_Q4)) {
                 quarter=Q4;
                 td = td.substring(0,td.length()-END_DASH_Q4.length());
                 month = MONTH_Q4;
             }
             else if(td.endsWith(END_Q1)) {
                 quarter=Q1;
                 td = td.substring(0,td.length()-END_Q1.length());
                 month = MONTH_Q1;
             }
             else if(td.endsWith(END_Q2)) {
                 quarter=Q2;
                 td = td.substring(0,td.length()-END_Q2.length());
                 month = MONTH_Q2;
             }
             else if( td.endsWith(END_Q3)) {
                 quarter=Q3;
                 td = td.substring(0,td.length()-END_Q3.length());
                 month = MONTH_Q3;
             }
             else if(td.endsWith(END_Q4)) {
                 quarter=Q4;
                 td = td.substring(0,td.length()-END_Q4.length());
                 month = MONTH_Q4;
             }
            year = Integer.parseInt(td);
            cal = Calendar.getInstance();
            cal.set(year, month, 1);
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
        if( o1 instanceof QuarterlyTimeDetail && o2 instanceof QuarterlyTimeDetail ) {
            QuarterlyTimeDetail ad = (QuarterlyTimeDetail)o1;
            QuarterlyTimeDetail ad2 = (QuarterlyTimeDetail)o2;
            return ad.getYear()-ad2.getYear();
        }
        else {
            System.out.println("o1="+o1);
            System.out.println("o2="+o2);
            throw new RuntimeException("Not A Time Detail");
        }
    }
    public String toString() {
      return Integer.toString(year)+"-Q"+quarter;
    }
    public int hashCode() {
       return year;
    }
    public boolean equals(Object o) {
      if( !(o instanceof QuarterlyTimeDetail )) return false;
      else {
         QuarterlyTimeDetail ad = (QuarterlyTimeDetail)o;
         return year==ad.getYear();
      }

    }

    /**
     * @return the quarter
     */
    public int getQuarter() {
        if( quarter == 0 ) throw new RuntimeException("Call to QuarterlyTimeDetail.getQuarter before quarter set!");
        return quarter;
    }

    /**
     * @param quarter the quarter to set
     */
    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public Calendar getCalendar() {
        return cal;
    }
    public String getTimeFormat(){return "P3M";}
}
