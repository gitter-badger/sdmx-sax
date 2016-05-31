/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="ConstraintContentTargetType">
		<xs:annotation>
			<xs:documentation>ConstraintTargetType defines the structure of a constraint target object. The constraint target object has a fixed representation and identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="ConstraintRepresentationType"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="optional" fixed="CONSTRAINT_CONTENT_TARGET"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */

public class ConstraintContentTargetType extends TargetObject {
    ConstraintRepresentationType localRepresentation = null;
}
