/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.CubeRegionKeyTypeChoice;

/**
 *	<xs:complexType name="CubeRegionKeyType">
		<xs:annotation>
			<xs:documentation>CubeRegionKeyType is a type for providing a set of values for a dimension for the purpose of defining a data cube region. A set of distinct value can be provided, or if this dimension is represented as time, and time range can be specified.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentValueSetType">
				<xs:choice>
					<xs:element name="Value" type="SimpleValueType" maxOccurs="unbounded"/>
					<xs:element name="TimeRange" type="TimeRangeValueType"/>
				</xs:choice>
				<xs:attribute name="id" type="SingleNCNameIDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CubeRegionKeyType extends ComponentValueSetType {

     CubeRegionKeyTypeChoice choice = null;
     SingleNCNameIDType id = null;
     public CubeRegionKeyType(CubeRegionKeyTypeChoice choice, SingleNCNameIDType id) {
         super(null,null);
         this.choice=choice;
         this.id=id;
     }
}
