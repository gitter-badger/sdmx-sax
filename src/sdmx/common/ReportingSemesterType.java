/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="ReportingSemesterType">
		<xs:annotation>
			<xs:documentation>ReportingSemesterType defines a time period of 6 months (P6M) in relation to a reporting year which has a start day (day-month) specified in the specialized reporting year start day attribute. In the absence of a start day for the reporting year, a day of January 1 is assumed. The format of a reporting semester is YYYY-Ss (e.g. 2000-S1), where s is either 1 or 2.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ReportPeriodValidTimeZoneType">
			<xs:pattern value=".{5}S[1-2].*"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class ReportingSemesterType extends ReportPeriodValidTimeZoneType {
    public static final String PATTERN = ".{5}S[1-2].*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
// Override Me
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
    public ReportingSemesterType(String s) {
        super(s);
    }
}
