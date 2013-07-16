/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="SingleNCNameIDType">
		<xs:annotation>
			<xs:documentation>SingleNCNameIDType restricts the NestedNCNameIDType to allow only one level. Note that this is the same pattern as the NCNameIDType, but can be used when the base type to be restricted is a nested NCNameIDType (where as the NCNameIDType could only restrict the IDType).</xs:documentation>
		</xs:annotation>
		<xs:restriction base="NestedNCNameIDType">
			<xs:pattern value="[A-z][A-z0-9_\-]*"/>
		</xs:restriction>
	</xs:simpleType>	
 * @author James
 */
public class SingleNCNameIDType extends NestedNCNameIDType {
    public static final String PATTERN = "[A-z][A-z0-9_\\-]*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};

    public SingleNCNameIDType(String s) {
        super(s);
    }
    @Override
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
