/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.common.ObservationDimensionType;

/**
 *	<xs:simpleType name="NCNameIDType">
		<xs:annotation>
			<xs:documentation>NCNameIDType restricts the IDType, so that the id may be used to generate valid XML components. IDs created from this type conform to the W3C XML Schema NCNAME type, and therefore can be used as element or attribute names.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="IDType">
			<xs:pattern value="[A-z][A-z0-9_\-]*"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class NCNameIDType extends IDType {
    public static final String PATTERN = "[A-z][A-z0-9_\\-]*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
    public NCNameIDType(String s) {
        super(s);
    }
        @Override
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
   public boolean equals(NCNameIDType id) {
        return super.getString().equals(id.getString());
    }
    public boolean equals(String id) {
        return super.getString().equals(id);
    }
}
