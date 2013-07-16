/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataConsumerReferenceType">
		<xs:annotation>
			<xs:documentation>DataConsumerReferenceType is a type for referencing a data consumer. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataConsumerRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataConsumerReferenceType extends OrganisationReferenceBaseType {
    public DataConsumerReferenceType(DataConsumerRefType ref, anyURI uri){
        super(ref,uri);
    }
    public DataConsumerReferenceType(anyURI uri){
        super(uri);
    }
}
