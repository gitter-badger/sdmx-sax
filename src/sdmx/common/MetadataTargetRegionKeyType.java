/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;

/**
 *	<xs:complexType name="MetadataTargetRegionKeyType">
		<xs:annotation>
			<xs:documentation>MetadataTargetRegionKeyType is a type for providing a set of values for a target object in a metadata target of a re fence metadata report. A set of values or a time range can be provided for a report period target object. A collection of the respective types of references can be provided for data set reference and identifiable object reference target objects. For a key descriptor values target object, a collection of data keys can be provided.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentValueSetType">
				<xs:choice>
					<xs:element name="Value" type="SimpleKeyValueType" maxOccurs="unbounded"/>
					<xs:element name="DataSet" type="SetReferenceType" maxOccurs="unbounded"/>
					<xs:element name="DataKey" type="DataKeyType" maxOccurs="unbounded"/>
					<xs:element name="Object" type="ObjectReferenceType" maxOccurs="unbounded"/>
					<xs:element name="TimeRange" type="TimeRangeValueType"/>
				</xs:choice>
				<xs:attribute name="id" type="SingleNCNameIDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataTargetRegionKeyType extends ComponentValueSetType {

    private MetadataTargetRegionKeyTypeChoice choice  = null;
    SingleNCNameIDType id = null;

    public MetadataTargetRegionKeyType(MetadataTargetRegionKeyTypeChoice val,NestedNCNameIDType id){
        super(null,id);
        this.choice=val;
    }
}
