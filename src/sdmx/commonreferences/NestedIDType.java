/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="NestedIDType">
		<xs:annotation>
			<xs:documentation>NestedIDType is the least restrictive form of an identifier used throughout all SDMX-ML messages. It allows for a hierarchical identifier, with each portion separated by the '.' character. For the identifier portions, valid characters include A-Z, a-z, @, 0-9, _, -, $.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:pattern value="[A-z0-9_@$\-]+(\.[A-z0-9_@$\-]+)*"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class NestedIDType extends RegexXMLString {
    public static final String PATTERN = "[A-z0-9_@$\\-]+(\\.[A-z0-9_@$\\-]+)*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};

    public NestedIDType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
   public boolean equals(NestedIDType id) {
        return super.getString().equals(id.getString());
    }
    public boolean equals(String id) {
        return super.getString().equals(id);
    }
    public boolean equals(IDType id) {
        //System.out.println("left="+this.getString()+" right="+id.getString());
        return super.getString().equals(id.getString());
    }
}
