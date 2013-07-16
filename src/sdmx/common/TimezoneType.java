/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.common;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="TimezoneType">
<xs:annotation>
<xs:documentation>TimezoneType defines the pattern for a time zone. An offset of -14:00 to +14:00 or Z can be specified.</xs:documentation>
</xs:annotation>
<xs:restriction base="xs:string">
<xs:pattern value="Z"/>
<xs:pattern value="(\+|\-)(14:00|((0[0-9]|1[0-3]):[0-5][0-9]))"/>
</xs:restriction>
</xs:simpleType>

 * @author James
 */
public class TimezoneType extends RegexXMLString {

    public static String PATTERN1 = "Z";
    public static String PATTERN2 = "(\\+|\\-)(14:00|((0[0-9]|1[0-3]):[0-5][0-9]))";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern REGEX_PATTERN2 = Pattern.compile(PATTERN2);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1,REGEX_PATTERN2};

    public TimezoneType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
