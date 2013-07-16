/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="NumericType">
		<xs:annotation>
			<xs:documentation>NumericType is a reusable simple type that allows for only numeric characters. This is not to be confused with an integer, as this may be used to numeric strings which have leading zeros. These leading zeros are not ignored. This is derived from the AlphaNumericType.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="AlphaNumericType">
			<xs:pattern value="[0-9]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class NumericType extends AlphaNumericType {
    public static final String PATTERN = "[0-9]+";
    public NumericType(String s) {
        super(s);
    }
}
