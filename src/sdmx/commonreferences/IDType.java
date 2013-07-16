/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="IDType">
		<xs:annotation>
			<xs:documentation>IDType provides a type which is used for restricting the characters in codes and IDs throughout all SDMX-ML messages. Valid characters include A-Z, a-z, @, 0-9, _, -, $.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="NestedIDType">
			<xs:pattern value="[A-z0-9_@$\-]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class IDType extends NestedIDType {
    public static final String PATTERN = "[A-z0-9_@$\\-]+";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};

    public IDType(String s) {
        super(s);
        if( s == null ) throw new RuntimeException("Null IDType:"+s);
    }
    @Override
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
    public boolean equals(IDType id) {
        if( super.getString()==null||id==null)return false;
        //System.out.println("left="+this.getString()+" right="+id.getString());
        return super.getString().equals(id.getString());
    }
    public boolean equals(String id) {
        if( super.getString()==null||id==null)return false;
        return super.getString().equals(id);
    }
}
