/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="RangeValidMonthDayType">
		<xs:annotation>
			<xs:documentation>RangeValidMonthDayType is a derivation of the BaseTimeRangeType which validates that the day provided is valid for the month, without regard to leap years. The base type will have provided basic validation already. The patterns below validate that there are up to 29 days in February, up to 30 days in April, June, September, and November and up to 31 days in January, March, May, July, August, October, and December. This type is meant to be derived from for further validation.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="BaseTimeRangeType">
			<xs:pattern value=".{5}02\-(0[1-9]|[1-2][0-9]).+"/>
			<xs:pattern value=".{5}(04|06|09|11)\-(0[1-9]|[1-2][0-9]|30).+"/>
			<xs:pattern value=".{5}(01|03|05|07|08|10|12)\-(0[1-9]|[1-2][0-9]|3[0-1]).+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class RangeValidMonthDayType extends BaseTimeRangeType {
    public static final String PATTERN1 = ".{5}02\\-(0[1-9]|[1-2][0-9]).+";
    public static final String PATTERN2 = ".{5}(04|06|09|11)\\-(0[1-9]|[1-2][0-9]|30).+";
    public static final String PATTERN3 = ".{5}(01|03|05|07|08|10|12)\\-(0[1-9]|[1-2][0-9]|3[0-1]).+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern REGEX_PATTERN2 = Pattern.compile(PATTERN2);
    public static final Pattern REGEX_PATTERN3 = Pattern.compile(PATTERN3);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1,REGEX_PATTERN2,REGEX_PATTERN3};
    public RangeValidMonthDayType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
