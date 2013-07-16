/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="OrganisationSchemeMapReferenceType">
		<xs:annotation>
			<xs:documentation>OrganisationSchemeMapReferenceType is a type for referencing a organisation scheme map object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="OrganisationSchemeMapRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class OrganisationSchemeMapReferenceType extends ChildObjectReferenceType {
    public OrganisationSchemeMapReferenceType(OrganisationSchemeMapRefType ref, anyURI uri){
        super(ref,uri);
    }
    public OrganisationSchemeMapReferenceType(anyURI uri){
        super(uri);
    }
}
