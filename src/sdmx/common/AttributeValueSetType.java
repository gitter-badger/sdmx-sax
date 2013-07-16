/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.AttributeValueSetTypeChoice;

/**
 *	<xs:complexType name="AttributeValueSetType">
		<xs:annotation>
			<xs:documentation>AttributeValueSetType defines the structure for providing values for a data attribute. If no values are provided, the attribute is implied to include/excluded from the region in which it is defined, with no regard to the value of the data attribute. Note that for metadata attributes which occur within other metadata attributes, a nested identifier can be provided. For example, a value of CONTACT.ADDRESS.STREET refers to the metadata attribute with the identifier STREET which exists in the ADDRESS metadata attribute in the CONTACT metadata attribute, which is defined at the root of the report structure.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentValueSetType">
				<xs:choice minOccurs="0">
					<xs:element name="Value" type="SimpleValueType" maxOccurs="unbounded"/>
					<xs:element name="TimeRange" type="TimeRangeValueType"/>
				</xs:choice>
				<xs:attribute name="id" type="SingleNCNameIDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AttributeValueSetType extends ComponentValueSetType {
    AttributeValueSetTypeChoice choice = null;
    SingleNCNameIDType id = null;
    public AttributeValueSetType(AttributeValueSetTypeChoice choice,SingleNCNameIDType id) {
        super(null,null);
        this.choice=choice;
        this.id=id;
    }


}
