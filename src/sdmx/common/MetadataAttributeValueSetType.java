/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.MetadataAttributeValueSetTypeChoice;

/**
 *	<xs:complexType name="MetadataAttributeValueSetType">
		<xs:annotation>
			<xs:documentation>MetadataAttributeValueSetType defines the structure for providing values for a metadata attribute. If no values are provided, the attribute is implied to include/excluded from the region in which it is defined, with no regard to the value of the metadata attribute.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentValueSetType">
				<xs:choice minOccurs="0">
					<xs:element name="Value" type="SimpleValueType" maxOccurs="unbounded"/>
					<xs:element name="TimeRange" type="TimeRangeValueType"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MetadataAttributeValueSetType {
    MetadataAttributeValueSetTypeChoice choice = null;
    public MetadataAttributeValueSetType(MetadataAttributeValueSetTypeChoice choice){
        this.choice=choice;
    }

}
