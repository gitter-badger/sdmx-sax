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
public class DateTime {

    public static final SimpleDateFormat DF = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    public static final SimpleDateFormat DF2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    private String baseString = null;
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

    public static DateTime fromString(String s) throws ParseException {
        if (s == null || "".equals(s)) {
            return null;
        }
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(DF.parse(s));
        } catch (ParseException ex) {
            try {
                cal.setTime(DF2.parse(s));
            } catch (ParseException ex2) {
                Logger.getLogger(CompactDataEventHandler.class
                        .getName()).log(Level.SEVERE, null, ex2);
            }
        }
        DateTime dt = new DateTime(cal);
        dt.setBaseString(s);
        return dt;
    }
    public String toString() {
        if( baseString!=null) return baseString;
        return DF.format(calendar.getTime());
    }
    public static DateTime now() {
        return new DateTime(Calendar.getInstance());
    }
    public void setBaseString(String s) {
        this.baseString=s;
    }
}
