/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="TimeRangeType">
		<xs:annotation>
			<xs:documentation>TimeRangeType defines the structure of a time range in SDMX. The pattern of a time range can be generally described as [start date]\[duration], where start date is an date or dateTime type as defined in XML Schema and duration is a time duration as defined in XML Schema. Note that it is permissible for a time zone offset to be provided on the date or date time.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="TimeRangeValidDateDurationType">
			<xs:pattern value=".+/P.*T(\d+H)?(\d+M)?(\d+(.\d+)?S)?"/>
			<xs:pattern value=".+/P[^T]+"/>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */
public class TimeRangeType extends TimeRangeValidDateDurationType {
     public static final String PATTERN1 = ".+/P.*T(\\d+H)?(\\d+M)?(\\d+(.\\d+)?S)?";
     public static final String PATTERN2 = ".+/P[^T]+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern REGEX_PATTERN2 = Pattern.compile(PATTERN2);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1,REGEX_PATTERN2};

    public TimeRangeType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
