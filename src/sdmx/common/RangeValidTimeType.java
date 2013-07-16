/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="RangeValidTimeType">
		<xs:annotation>
			<xs:documentation>RangeValidTimeType is a derivation of the RangeValidLeapYearType which validates that the time (if provided) is validly formatted. The base type will have provided basic validation already. The patterns below validate that the time falls between 00:00:00 and 24:00:00. Note that as the XML dateTime type does, seconds are required. It is also permissible to have fractions of seconds, but only within the boundaries of the range specified. This type is meant to be derived from for further validation.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="RangeValidLeapYearType">
			<xs:pattern value=".{10}T(24:00:00(\.[0]+)?|((([0-1][0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9](\.\d+)?))(/|Z|\+|\-).+"/>
			<xs:pattern value="[^T]+/.+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class RangeValidTimeType extends RangeValidLeapYearType {
      public static final String PATTERN1 = ".{10}T(24:00:00(\\.[0]+)?|((([0-1][0-9])|(2[0-3])):[0-5][0-9]:[0-5][0-9](\\.\\d+)?))(/|Z|\\+|\\-).+";
      public static final String PATTERN2 = "[^T]+/.+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern REGEX_PATTERN2 = Pattern.compile(PATTERN2);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1,REGEX_PATTERN2};
    public RangeValidTimeType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
