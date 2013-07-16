/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="DataSetTargetType">
		<xs:annotation>
			<xs:documentation>DataSetTargetType defines the structure of a data set target object. The data set target object has a fixed representation and identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="DataSetRepresentationType"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="optional" fixed="DATA_SET_TARGET"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataSetTargetType extends TargetObject {
    
}
