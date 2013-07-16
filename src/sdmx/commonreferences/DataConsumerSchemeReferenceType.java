/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataConsumerSchemeReferenceType">
		<xs:annotation>
			<xs:documentation>DataConsumerSchemeReferenceType is a type for referencing a data consumer scheme object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataConsumerSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DataConsumerSchemeReferenceType extends OrganisationSchemeReferenceBaseType {
    public DataConsumerSchemeReferenceType(DataConsumerSchemeRefType ref, anyURI uri) {
        super(ref,uri);
    }
    public DataConsumerSchemeReferenceType(anyURI uri) {
        super(uri);
    }
    
}
