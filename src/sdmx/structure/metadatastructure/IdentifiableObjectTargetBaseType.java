/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="IdentifiableObjectTargetBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>IdentifiableObjectTargetBaseType is an abstract base type which forms the basis for the IdentifiableObjectTargetType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="IdentifiableObjectRepresentationType"/>				
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class IdentifiableObjectTargetBaseType extends TargetObject {
    
}
