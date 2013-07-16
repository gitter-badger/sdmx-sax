/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="AlphaType">
		<xs:annotation>
			<xs:documentation>AlphaType is a reusable simple type that allows for only mixed-case alphabetical characters. This is derived from the AlphaNumericType.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="AlphaNumericType">
			<xs:pattern value="[A-z]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class AlphaType extends AlphaNumericType {
    public static final String PATTERN = "[A-z]+";
    String s=null;
    public AlphaType(String s) {
        super(s);
        // TO DO: validation
    }
}
