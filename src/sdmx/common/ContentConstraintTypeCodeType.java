/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="ContentConstraintTypeCodeType">
		<xs:annotation>
			<xs:documentation>ContentConstraintTypeCodeType defines a list of types for a content constraint. A content constraint can state which data is present or which content is allowed for the constraint attachment.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="Allowed">
				<xs:annotation>
					<xs:documentation>The constraint contains the allowed values for attachable object.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="Actual">
				<xs:annotation>
					<xs:documentation>The constraints contains the actual data present for the attachable object.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class ContentConstraintTypeCodeType {
       public static final String ALLOWED = "Allowed";
       public static final String ACTUAL = "Actual";
}
