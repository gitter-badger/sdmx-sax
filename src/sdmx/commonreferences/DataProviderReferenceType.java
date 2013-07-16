/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataProviderReferenceType">
		<xs:annotation>
			<xs:documentation>DataProviderReferenceType is a type for referencing a data provider. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataProviderRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataProviderReferenceType extends OrganisationReferenceBaseType {

    public DataProviderReferenceType(DataProviderRefType ref,anyURI uri) {
        super(ref,uri);
    }
    public DataProviderReferenceType(anyURI uri) {
        super(uri);
    }
    
}
