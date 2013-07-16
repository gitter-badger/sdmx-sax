/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="AgencySchemeReferenceType">
		<xs:annotation>
			<xs:documentation>AgencySchemeReferenceType is a type for referencing an agency scheme object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="AgencySchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class AgencySchemeReferenceType extends OrganisationSchemeReferenceBaseType {
    public AgencySchemeReferenceType(AgencySchemeRefType ref,anyURI uri) {
        super(ref,uri);
    }
    public AgencySchemeReferenceType(anyURI uri) {
        super(uri);
    }
    
}
