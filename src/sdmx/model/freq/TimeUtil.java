/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.freq;

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
public class TimeUtil {

    public static TimeDetail parse(String freq, String s) {
        if ("".equals(s)) {
            throw new RuntimeException("Time Detail of \'\'");
        }
        if (freq != null) {
            if ("A".equals(freq)) {
                return new AnnualTimeDetail(s);
            } else if ("B".equals(freq)) {
                return new BusinessTimeDetail(s);
            } else if ("D".equals(freq)) {
                return new DailyTimeDetail(s);
            } else if ("M".equals(freq)) {
                return new MonthlyTimeDetail(s);
            } else if ("N".equals(freq)) {
                return new MinutelyTimeDetail(s);
            } else if ("Q".equals(freq)) {
                return new QuarterlyTimeDetail(s);
            } else if ("S".equals(freq)) {
                return new HalfYearlyTimeDetail(s);
            } else if ("W".equals(freq)) {
                return new WeeklyTimeDetail(s);
            }
        }
        return new StringTimeDetail(s);
    }
}
