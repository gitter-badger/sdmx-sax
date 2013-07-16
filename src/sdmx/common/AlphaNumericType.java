/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="AlphaNumericType">
		<xs:annotation>
			<xs:documentation>AlphaNumericType is a reusable simple type that allows for only mixed-case alphabetical and numeric characters.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:pattern value="[A-z0-9]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class AlphaNumericType extends RegexXMLString {
    public static final String PATTERN = "[A-z0-9]+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1};
    public AlphaNumericType(String s) {
        super(s);
    }
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }

}
