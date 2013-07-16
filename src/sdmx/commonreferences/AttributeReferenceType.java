/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="AttributeReferenceType">
		<xs:annotation>
			<xs:documentation>AttributeReferenceType is a type for referencing an attribute object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="AttributeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AttributeReferenceType extends ComponentReferenceType {
    public AttributeReferenceType(AttributeRefType ref, anyURI uri){
        super(ref,uri);
    }
    public AttributeReferenceType(anyURI uri){
        super(uri);
    }
}
