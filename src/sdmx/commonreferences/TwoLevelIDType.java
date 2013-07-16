/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *		<xs:simpleType name="TwoLevelIDType">
		<xs:annotation>
			<xs:documentation>TwoLevelIDType defines an identifier with exactly two levels.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="NestedIDType">
			<xs:pattern value="[A-z0-9_@$\-]+\.[A-z0-9_@$\-]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class TwoLevelIDType extends RegexXMLString {
    public static final String PATTERN = "[A-z0-9_@$\\-]+\\.[A-z0-9_@$\\-]+";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};

    public TwoLevelIDType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
