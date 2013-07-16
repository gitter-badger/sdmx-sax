/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="TimeRangeValidDateDurationType">
		<xs:annotation>
			<xs:documentation>TimeRangeValidDateDurationType is an abstract derivation of the RangeValidTimeType which validates that duration provided is generally valid, up to the time component.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="RangeValidTimeZoneType">
			<xs:pattern value=".+/P(\d+Y)?(\d+M)?(\d+D)?(T.+)?"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class TimeRangeValidDateDurationType extends RangeValidTimeZoneType {
    public static final String PATTERN = ".+/P(\\d+Y)?(\\d+M)?(\\d+D)?(T.+)?";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1};

    public TimeRangeValidDateDurationType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
