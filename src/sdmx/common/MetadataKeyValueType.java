/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.MetadataKeyValueTypeChoice;

/**
 *	<xs:complexType name="MetadataKeyValueType">
		<xs:annotation>
			<xs:documentation>MetadataKeyValueType is a type for providing a target object value for the purpose of defining a distinct metadata key. Only a single value can be provided for the target object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DinstinctKeyValueType">
				<xs:choice>
					<xs:element name="Value" type="SimpleKeyValueType"/>
					<xs:element name="DataSet" type="SetReferenceType"/>
					<xs:element name="DataKey" type="DataKeyType"/>
					<xs:element name="Object" type="ObjectReferenceType"/>
				</xs:choice>
				<xs:attribute name="id" type="SingleNCNameIDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MetadataKeyValueType extends DistinctKeyValueType {
     private MetadataKeyValueTypeChoice choice = null;
     private SingleNCNameIDType id = null;
     public MetadataKeyValueType(MetadataKeyValueTypeChoice choice,SingleNCNameIDType id){
         super(null,id);
         this.choice=choice;
         this.id=id;
     }
}
