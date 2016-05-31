/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="KeyDescriptorValuesTargetType">
		<xs:annotation>
			<xs:documentation>KeyDescriptorValuesTargetType defines the structure of a key descriptor values target object. The key descriptor values target object has a fixed representation and identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="KeyDescriptorValuesRepresentationType"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="optional" fixed="DIMENSION_DESCRIPTOR_VALUES_TARGET"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
	

 * @author James
 */

public class KeyDescriptorValuesTargetType extends TargetObject {
    
}
