/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import sdmx.structure.base.ComponentType;

/**
 *	<xs:complexType name="MetadataAttributeBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>MetadataAttributeBaseType is an abstract base type the serves as the basis for the MetadataAttributeType.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:restriction base="ComponentType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="ConceptIdentity" type="common:ConceptReferenceType"/>
					<xs:element name="LocalRepresentation" type="MetadataAttributeRepresentationType" minOccurs="0"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>	
	</xs:complexType>

 * @author James
 */
public class MetadataAttributeBaseType extends ComponentType {
    
}
