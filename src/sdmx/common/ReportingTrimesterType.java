/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="ReportingTrimesterType">
		<xs:annotation>
			<xs:documentation>ReportingTrimesterType defines a time period of 4 months (P4M) in relation to a reporting year which has a start day (day-month) specified in the specialized reporting year start day attribute. In the absence of a start day for the reporting year, a day of January 1 is assumed. The format of a reporting trimester is YYYY-Tt (e.g. 2000-T1), where s is either 1, 2, or 3.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ReportPeriodValidTimeZoneType">
			<xs:pattern value=".{5}T[1-3].*"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class ReportingTrimesterType extends ReportingTimePeriodType
{
    public static final String PATTERN = ".{5}T[1-3].*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
// Override Me
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
    public ReportingTrimesterType(String s) {
        super(s);
    }
}
