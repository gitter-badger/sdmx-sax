/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.DistinctKeyValueTypeChoice;
import sdmx.common.choice.MetadataKeyValueTypeChoice;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;

/**
 *	<xs:complexType name="DataKeyType">
		<xs:annotation>
			<xs:documentation>DataKeyType is a region which defines a distinct full or partial data key. The key consists of a set of values, each referencing a dimension and providing a single value for that dimension. The purpose of the key is to define a subset of a data set (i.e. the observed value and data attribute) which have the dimension values provided in this definition. Any dimension not stated explicitly in this key is assumed to be wild carded, thus allowing for the definition of partial data keys.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DistinctKeyType">
				<xs:sequence>
					<xs:element name="KeyValue" type="DataKeyValueType" maxOccurs="unbounded"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DataKeyType extends DistinctKeyType implements ComponentValueSetTypeChoice,DistinctKeyValueTypeChoice,MetadataKeyValueTypeChoice,MetadataTargetRegionKeyTypeChoice {
    private List<DataKeyValueType> keyValues = null;
    public DataKeyType(List<DataKeyValueType> choices, List<ComponentValueSetType> attrs) {
        super(attrs,toDVT(choices));
        this.keyValues=choices;
    }
    private static List<DistinctKeyValueType> toDVT(List<DataKeyValueType> keys) {
        List<DistinctKeyValueType> list = new ArrayList<DistinctKeyValueType>(keys.size());
        list.addAll(keys);
        return list;
    }
    public DataKeyValueType getDataKeyValueType(int i) {
        return keyValues.get(i);
    }
    public int getDataKeyValueTypeSize() { return keyValues.size(); }
}