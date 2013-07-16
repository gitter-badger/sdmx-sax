/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="AgencyReferenceType">
		<xs:annotation>
			<xs:documentation>AgencyReferenceType is a type for referencing an agency. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="AgencyRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class AgencyReferenceType extends OrganisationReferenceBaseType {
    public AgencyReferenceType(AgencyRefType ref, anyURI uri){
        super(ref,uri);
    }
    public AgencyReferenceType(anyURI uri){
        super(null,uri);
    }
}
