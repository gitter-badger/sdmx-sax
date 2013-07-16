/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="OrganisationUnitSchemeReferenceType">
		<xs:annotation>
			<xs:documentation>OrganisationUnitSchemeReferenceType is a type for referencing an organisation unit scheme object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="OrganisationUnitSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class OrganisationUnitSchemeReferenceType extends OrganisationSchemeReferenceBaseType {
    public OrganisationUnitSchemeReferenceType(OrganisationUnitSchemeRefType ref,anyURI urn) {
        super(ref,urn);
    }
    public OrganisationUnitSchemeReferenceType(anyURI urn) {
        super(null,urn);
    }    
}
