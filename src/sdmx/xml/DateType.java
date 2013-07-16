/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.xml;

import java.util.Calendar;
import sdmx.common.GregorianTimePeriodType;

/**
 *
 * @author James
 */
public class DateType {//implements GregorianTimePeriodType{
     int year = 0;
     int month = 0;
     int date = 0;
     public DateType(int year,int month,int d) {
         this.year=year;
         this.month=month;
         this.date=d;
     }
     public int getYear() { return year; }
     public int getMonth() { return month; }
     public int getDate() { return date; }
}
