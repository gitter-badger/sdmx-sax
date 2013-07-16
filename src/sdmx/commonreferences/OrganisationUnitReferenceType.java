/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="OrganisationUnitReferenceType">
		<xs:annotation>
			<xs:documentation>OrganisationUnitReferenceType is a type for referencing an organisation unit. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="OrganisationUnitRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class OrganisationUnitReferenceType extends OrganisationReferenceBaseType {
    public OrganisationUnitReferenceType(OrganisationUnitRefType ref, anyURI urn){
        super(ref,urn);
    }
    public OrganisationUnitReferenceType(anyURI urn){
        super(null,urn);
    }
}
