/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;
/**
 *	<xs:simpleType name="ObservationalTimePeriodType">
		<xs:annotation>
			<xs:documentation>ObservationalTimePeriodType specifies a distinct time period or point in time in SDMX. The time period can either be a Gregorian calendar period, a standard reporting period, a distinct point in time, or a time range with a specific date and duration.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="StandardTimePeriodType TimeRangeType"/>
	</xs:simpleType>
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
public class ObservationalTimePeriodType {
    // Year
    public static final String PATTERN_YEAR = ".{5}A1.*";
    // Semester
    public static final String PATTERN_SEMESTER = ".{5}S[1-2].*";
    // Trimester
    public static final String PATTERN_TRIMESTER = ".{5}T[1-3].*";
    // Quarter
    public static final String PATTERN_QUARTER = ".{5}Q[1-4].*";
    // Month
    public static final String PATTERN_MONTH = ".{5}M(0[1-9]|1[0-2]).*";
    // Week
    public static final String PATTERN_WEEK = ".{5}W(0[1-9]|[1-4][0-9]|5[0-3]).*";
    // Day
    public static final String PATTERN_DAY = ".{5}D(0[0-9][1-9]|[1-2][0-9][0-9]|3[0-5][0-9]|36[0-6]).*";
    
    public static final Pattern REGEX_YEAR = Pattern.compile(PATTERN_YEAR);
    public static final Pattern REGEX_SEMESTER = Pattern.compile(PATTERN_SEMESTER);
    public static final Pattern REGEX_TRIMESTER = Pattern.compile(PATTERN_TRIMESTER);
    public static final Pattern REGEX_QUARTER = Pattern.compile(PATTERN_QUARTER);
    public static final Pattern REGEX_MONTH = Pattern.compile(PATTERN_MONTH);
    public static final Pattern REGEX_WEEK = Pattern.compile(PATTERN_WEEK);
    public static final Pattern REGEX_DAY = Pattern.compile(PATTERN_DAY);
    
    public static final int YEAR = 1;
    public static final int SEMESTER = 2;
    public static final int TRIMESTER = 3;
    public static final int QUARTER = 4;
    public static final int MONTH = 5;
    public static final int WEEK = 6;
    public static final int DAY = 7;
    
    private int state = YEAR;
    private String value = null;
    
    public ObservationalTimePeriodType(String s) {
        value=s;
        if( REGEX_YEAR.matcher(s).matches()) {
            state=YEAR;
        }
        else if( REGEX_SEMESTER.matcher(s).matches()) {
            state=SEMESTER;
        }
        else if( REGEX_TRIMESTER.matcher(s).matches()) {
            state=TRIMESTER;
        }
        else if( REGEX_QUARTER.matcher(s).matches()) {
            state=QUARTER;
        }
        else if( REGEX_MONTH.matcher(s).matches()) {
            state=MONTH;
        }
        else if( REGEX_WEEK.matcher(s).matches()) {
            state=WEEK;
        }
        else if( REGEX_DAY.matcher(s).matches()) {
            state=DAY;
        }
    }
    public String toString() {
        return value;
    }
}
