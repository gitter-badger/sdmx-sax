/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="WildCardValueType">
		<xs:annotation>
			<xs:documentation>WildCardValueType is a single value code list, used to include the '%' character - indicating that an entire field is wild carded.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="%">
				<xs:annotation>
					<xs:documentation>Indicates a wild card value.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class WildCardValueType {
    public static final String value = "%";
}
