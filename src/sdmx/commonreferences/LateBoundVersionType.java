/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="LateBoundVersionType">
		<xs:annotation>
			<xs:documentation>LateBoundVersionType is a single value code list, used to include the '*' character - indicating that the latest version of an object is required.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="*">
				<xs:annotation>
					<xs:documentation>Indicates that the latest version of an object is requested.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class LateBoundVersionType extends RegexXMLString {
    public static final String LATE_VERSION_TEXT = "*";
    public static final LateBoundVersionType LATE_BOUND_VERSION = new LateBoundVersionType();

    private LateBoundVersionType() {
        super("*");
    }
}
