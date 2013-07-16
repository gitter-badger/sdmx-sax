/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="KeyDescriptorReferenceType">
		<xs:annotation>
			<xs:documentation>KeyDescriptorReferenceType is a type for referencing a key descriptor object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="KeyDescriptorRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class KeyDescriptorReferenceType extends ComponentListReferenceType {
    public KeyDescriptorReferenceType(KeyDescriptorRefType ref, anyURI uri){
       super(ref,uri);
    }
    public KeyDescriptorReferenceType(anyURI uri){
       super(uri);
    }
}
