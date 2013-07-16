/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 * 	<xs:complexType name="OrganisationReferenceType">
		<xs:annotation>
			<xs:documentation>OrganisationReferenceType references an organisation regardless of the specific type. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationReferenceBaseType">
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
public class OrganisationReferenceType extends OrganisationReferenceBaseType {
    public OrganisationReferenceType(OrganisationRefBaseType ref,anyURI urn) {
        super(ref,urn);
    }
    public OrganisationReferenceType(anyURI urn) {
        super(urn);
    }
    
}
