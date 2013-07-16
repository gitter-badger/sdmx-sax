/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="GroupKeyDescriptorReferenceType">
		<xs:annotation>
			<xs:documentation>GroupKeyDescriptorReferenceType is a type for referencing a group key descriptor object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="GroupKeyDescriptorRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class GroupKeyDescriptorReferenceType extends ComponentListReferenceType {
    public GroupKeyDescriptorReferenceType(GroupKeyDescriptorRefType ref, anyURI uri){
       super(ref,uri);
    }
    public GroupKeyDescriptorReferenceType(anyURI uri){
       super(uri);
    }
}
