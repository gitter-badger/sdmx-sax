/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.DistinctKeyValueTypeChoice;

/**
 *	<xs:complexType name="DinstinctKeyValueType" abstract="true">
		<xs:annotation>
			<xs:documentation>DinstinctKeyValueType is an abstract base type which defines a singular, required value for a key component.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentValueSetType">
				<xs:choice>
					<xs:element name="Value" type="SimpleKeyValueType"/>
					<xs:element name="DataSet" type="SetReferenceType"/>
					<xs:element name="DataKey" type="DataKeyType"/>
					<xs:element name="Object" type="ObjectReferenceType"/>
				</xs:choice>
				<xs:attribute name="id" type="SingleNCNameIDType" use="required"/>
				<xs:attribute name="include" type="xs:boolean" use="optional" fixed="true"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DistinctKeyValueType extends ComponentValueSetType {
       DistinctKeyValueTypeChoice choice = null;
       private SingleNCNameIDType id = null;
       private static final boolean include = true;

       public DistinctKeyValueType(DistinctKeyValueTypeChoice choice,SingleNCNameIDType id) {
           super(choice,null);
           this.choice=choice;
           this.id=id;
       }
}
