/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="RangeValidTimeZoneType">
		<xs:annotation>
			<xs:documentation>RangeValidMonthDayType is a derivation of the RangeValidTimeType which validates that the time zone provided in the base type is valid. The base type will have provided basic validation already. The patterns below validate that the time zone is "Z" or that it is between -14:00 and +14:00, or that there is no time zone provided. This type is meant to be derived from for further validation.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="RangeValidTimeType">
			<xs:pattern value=".+Z/.+"/>
			<xs:pattern value=".{10}.*(\+|\-)(14:00|((0[0-9]|1[0-3]):[0-5][0-9]))/.+"/>
			<xs:pattern value=".{10}[^\+\-Z]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class RangeValidTimeZoneType extends RangeValidTimeType {
     public static final String PATTERN1 = ".+Z/.+";
     public static final String PATTERN2 = ".{10}.*(\\+|\\-)(14:00|((0[0-9]|1[0-3]):[0-5][0-9]))/.+";
     public static final String PATTERN3 = ".{10}[^\\+\\-Z]+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern REGEX_PATTERN2 = Pattern.compile(PATTERN2);
    public static final Pattern REGEX_PATTERN3 = Pattern.compile(PATTERN3);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1,REGEX_PATTERN2,REGEX_PATTERN3};
    public RangeValidTimeZoneType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}