/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="ReportingWeekType">
		<xs:annotation>
			<xs:documentation>ReportingWeekType defines a time period of 7 days (P7D) in relation to a reporting year which has a start day (day-month) specified in the specialized reporting year start day attribute. A standard reporting week is based on the ISO 8601 defintion of a week date, in relation to the reporting period start day. The first week is defined as the week with the first Thursday on or after the reporting year start day. An equivalent definition is the week starting with the Monday nearest in time to the reporting year start day. There are other equivalent defintions, all of which should be adjusted based on the reporting year start day. In the absence of a start day for the reporting year, a day of January 1 is assumed. The format of a reporting week is YYYY-Www (e.g. 2000-W01), where mm is a two digit week (i.e. 01-53).</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ReportPeriodValidTimeZoneType">
			<xs:pattern value=".{5}W(0[1-9]|[1-4][0-9]|5[0-3]).*"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class ReportingWeekType extends RegexXMLString {
    public static final String PATTERN = ".{5}W(0[1-9]|[1-4][0-9]|5[0-3]).*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
// Override Me
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
    public ReportingWeekType(String s) {
        super(s);
    }
}
