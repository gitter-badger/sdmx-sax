/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="AttributeDescriptorReferenceType">
		<xs:annotation>
			<xs:documentation>AttributeDescriptorReferenceType is a type for referencing an attribute descriptor object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="AttributeDescriptorRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AttributeDescriptorReferenceType extends ComponentListReferenceType {
    public AttributeDescriptorReferenceType(AttributeDescriptorRefType ref, anyURI uri){
       super(ref,uri);
    }
    public AttributeDescriptorReferenceType(anyURI uri){
       super(uri);
    }
}
