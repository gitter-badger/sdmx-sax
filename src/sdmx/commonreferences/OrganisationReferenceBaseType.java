/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="OrganisationReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>OrganisationReferenceBaseType is a type for referencing any organisation object, regardless of its type. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="OrganisationRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class OrganisationReferenceBaseType extends ItemReferenceType {
    public OrganisationReferenceBaseType(OrganisationRefBaseType ref,anyURI uri) {
        super(ref,uri);
    }
    public OrganisationReferenceBaseType(anyURI uri) {
        super(uri);
    }
}
