/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.xml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.common.BasicTimePeriodType;
import sdmx.version.twopointzero.compact.CompactDataEventHandler;

/**
 *
 * @author James
 */
public class DateTime {

    private static final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    private static final SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    java.util.Date date = null;
    Calendar calendar = null;

    public DateTime(Date d) {
        this.date = d;
        this.calendar = Calendar.getInstance();
        calendar.setTime(date);
    }

    public DateTime(Calendar c) {
        this.date = c.getTime();
        this.calendar = c;
    }

    public Calendar toCalendar() {
        return calendar;
    }

    public Date getDate() {
        return date;
    }

    public static DateTime fromString(String s) {
        if (s == null || "".equals(s)) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(df.parse(s));
        } catch (ParseException ex) {
            try {
                cal.setTime(df2.parse(s));
            } catch (ParseException ex2) {
                Logger.getLogger(CompactDataEventHandler.class
                        .getName()).log(Level.SEVERE, null, ex2);
            }
        }
        return new DateTime(cal);
    }
    public String toString() {
        return df.format(calendar.getTime());
    }
    public static DateTime now() {
        return new DateTime(Calendar.getInstance());
    }
}
