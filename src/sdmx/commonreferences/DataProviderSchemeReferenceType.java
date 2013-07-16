/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataProviderSchemeReferenceType">
		<xs:annotation>
			<xs:documentation>DataProviderSchemeReferenceType is a type for referencing a data provider scheme object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataProviderSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DataProviderSchemeReferenceType extends OrganisationSchemeReferenceBaseType {
    public DataProviderSchemeReferenceType(DataProviderSchemeRefType ref, anyURI uri){
        super(ref,uri);
    }
    
}
