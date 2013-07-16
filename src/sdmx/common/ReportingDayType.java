/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="ReportingDayType">
		<xs:annotation>
			<xs:documentation>ReportingDayType defines a time period of 1 day (P1D) in relation to a reporting year which has a start day (day-month) specified in the specialized reporting year start day attribute. In the absence of a start day for the reporting year, a day of January 1 is assumed. The format of a reporting day is YYYY-Dddd (e.g. 2000-D001), where ddd is a three digit day (i.e. 001-366).</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ReportPeriodValidTimeZoneType">
			<xs:pattern value=".{5}D(0[0-9][1-9]|[1-2][0-9][0-9]|3[0-5][0-9]|36[0-6]).*"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class ReportingDayType extends ReportPeriodValidTimeZoneType {
    public static final String PATTERN = ".{5}D(0[0-9][1-9]|[1-2][0-9][0-9]|3[0-5][0-9]|36[0-6]).*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
// Override Me
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
    public ReportingDayType(String s) {
        super(s);
    }
}
