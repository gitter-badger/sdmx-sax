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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class HalfYearlyTimeDetail implements TimeDetail {

    public static final int B1 = 1;
    public static final int B2 = 2;
    public static final String END_B1 = "B1";
    public static final String END_DASH_B1 = "-B1";
    public static final String END_B2 = "B2";
    public static final String END_DASH_B2 = "-B2";

    public static final int MONTH_B1 = 1;
    public static final int MONTH_B2 = 6;


    private int year = 0;
    private int half = 0;
    transient Calendar cal = null;

         public HalfYearlyTimeDetail(String td) {
             if( td.endsWith(END_B1)) {
                 half=B1;
                 td = td.substring(0,td.length()-END_B1.length());
             }
             if( td.endsWith(END_DASH_B1)) {
                 half=B1;
                 td = td.substring(0,td.length()-END_DASH_B1.length());
             }
             if( td.endsWith(END_B2)) {
                 half=B1;
                 td = td.substring(0,td.length()-END_B2.length());
             }
             if( td.endsWith(END_DASH_B2)) {
                 half=B1;
                 td = td.substring(0,td.length()-END_DASH_B2.length());
             }
            year = Integer.parseInt(td);
            cal = Calendar.getInstance();
            cal.set(year, (half==B1?MONTH_B1:MONTH_B2),1);
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
        if( o1 instanceof HalfYearlyTimeDetail && o2 instanceof HalfYearlyTimeDetail ) {
            HalfYearlyTimeDetail ad = (HalfYearlyTimeDetail)o1;
            HalfYearlyTimeDetail ad2 = (HalfYearlyTimeDetail)o2;
            int res = ad.getYear()-ad2.getYear();
            if( res!=0)return res;
            res = ad.getHalf()-ad2.getHalf();
            return res;
        }
        else {
            System.out.println("o1="+o1);
            System.out.println("o2="+o2);
            throw new RuntimeException("Not A Time Detail");
        }
    }
    public String toString() {
      return Integer.toString(year);
    }
    public int hashCode() {
       return year;
    }
    public boolean equals(Object o) {
      if( !(o instanceof HalfYearlyTimeDetail )) return false;
      else {
         HalfYearlyTimeDetail ad = (HalfYearlyTimeDetail)o;
         return year==ad.getYear();
      }

    }

    /**
     * @return the quarter
     */
    public int getHalf() {
        if( half == 0 ) throw new RuntimeException("Call to QuarterlyTimeDetail.getQuarter before quarter set!");
        return half;
    }

    /**
     * @param quarter the quarter to set
     */
    public void setHalf(int h) {
        if( h<1||h>2)throw new RuntimeException("BiAnnualTimeDetail.setHalf("+h+")");
        this.half = h;
    }
    public Calendar getCalendar() {
        return cal;
    }
    public String getTimeFormat() { return "P6M"; }
}
