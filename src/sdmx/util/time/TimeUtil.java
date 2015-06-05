/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
package sdmx.util.time;

import java.util.Calendar;
import java.util.Locale;
import org.jfree.data.time.Day;
import org.jfree.data.time.Month;
import org.jfree.data.time.Quarter;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimePeriodFormatException;
import org.jfree.data.time.Week;
import org.jfree.data.time.Year;
import org.jfree.date.SerialDate;
import sdmx.data.key.FullKey;
import sdmx.structure.base.ItemType;

/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class TimeUtil {

    public static RegularTimePeriod createTimePeriod(FullKey key, String time) {
        ItemType freq = (ItemType) key.getComponent("FREQ");
        if (freq == null) {
            freq = (ItemType) key.getComponent("FREQUENCY");
        }
        if (freq == null) {
            freq = (ItemType) key.getComponent("TIME_FORMAT");
        }
        RegularTimePeriod rtime = parseTime(freq.getId().toString(), time);
        System.out.println("Time=" + rtime);
        return rtime;
    }
/* notes from Edgardo Greising from ILO.org
    The concept of Time Format is sometimes tied to the frequency, 
    but more precisely to the reference period of the datum. 
    In our case the time format can be taken from the time value 
    which is stored in a proprietary extension of the ISO 8601 format
    that we call "User format". It is defined as [YYYY] for years (Ex.: 2009), 
    [YYYY]Q[Q] for quarters (Ex.: 2011Q3) and [YYYY]M[MM] for months (Ex.: 2014M06). 
    So the fourth character of the TIME concept value gives the reference period: 
    Yearly (by absence), Quarterly or Monthly. We can also use other codes to represent
    other periods like S for Semesters or W for weeks, but we don't have this type of 
    data so far. In any case, the valid codes are in the CL_FREQ codelist.
*/
    public static RegularTimePeriod parseTime(String freq, String s) {
        if ("".equals(s)) {
            throw new RuntimeException("Time Detail of \'\'");
        }
        try{
        if ("A".equals(freq)||"P1Y".equals(freq)) {
            return Year.parseYear(s);
        } else if ("B".equals(freq)||"P1B".equals(freq)) {
            return Day.parseDay(s);
        } else if ("D".equals(freq)||"P1D".equals(freq)) {
            return Day.parseDay(s);
        } else if ("M".equals(freq)||"P1M".equals(freq)) {
            return Month.parseMonth(s);
        } else if ("Q".equals(freq)||"P3M".equals(freq)) {
            return Quarter.parseQuarter(s);
        } else if ("S".equals(freq)||"P6M".equals(freq)) {
            return Semester.parseSemester(s);
        } else if ("W".equals(freq)||"P1W".equals(freq)) {
            return Week.parseWeek(s);
        }
        }catch(TimePeriodFormatException tpfe) {
            System.out.println("Time:"+s+" is not a format for freq:"+freq);
        }catch(StringIndexOutOfBoundsException sioob){
        }
        RegularTimePeriod rtd = null;
        try {
            rtd = Year.parseYear(s);
        } catch (TimePeriodFormatException tpe) {
        }catch(StringIndexOutOfBoundsException sioob){
        }
        if (rtd != null) {
            return rtd;
        }
        try {
            rtd = Day.parseDay(s);
        } catch (TimePeriodFormatException tpe) {
        }catch(StringIndexOutOfBoundsException sioob){
        }
        if (rtd != null) {
            return rtd;
        }
        try {
            rtd = Month.parseMonth(s);
        } catch (TimePeriodFormatException tpe) {
        }catch(StringIndexOutOfBoundsException sioob){
        }
        if (rtd != null) {
            return rtd;
        }
        try {
            rtd = Quarter.parseQuarter(s);
        } catch (TimePeriodFormatException tpe) {
        }catch(StringIndexOutOfBoundsException sioob){
        }
        if (rtd != null) {
            return rtd;
        }
        try {
            rtd = Semester.parseSemester(s);
        } catch (TimePeriodFormatException tpe) {
        }catch(StringIndexOutOfBoundsException sioob){
        }
        if (rtd != null) {
            return rtd;
        }
        try {
            rtd = Week.parseWeek(s);
        } catch (TimePeriodFormatException tpe) {
        }catch(StringIndexOutOfBoundsException sioob){
        }
        if (rtd != null) {
            return rtd;
        }
        throw new RuntimeException("Null Frequency Field");
    }

    public static String getTickFormat(String freq) {
        if (freq != null) {
            if ("A".equals(freq)||"P1Y".equals(freq)) {
                return "%Y";
            } else if ("B".equals(freq)||"P1B".equals(freq)) {
                return "%Y-%m-%d";
            } else if ("D".equals(freq)||"P1D".equals(freq)) {
                return "%Y-%m-%d";
            } else if ("M".equals(freq)||"P1M".equals(freq)) {
                return "%Y-%m";
            } else if ("Q".equals(freq)||"P3M".equals(freq)) {
                return "%Y-%m";
            } else if ("S".equals(freq)||"P6M".equals(freq)) {
                return "%Y-%m";
            } else if ("W".equals(freq)||"P1W".equals(freq)) {
                return "%Y-%m-%d";
            } else {
                // Default to Day
                return "%Y-%m-%d";
            }
        } else {
            throw new RuntimeException("Null freq field");
        }
    }
}
