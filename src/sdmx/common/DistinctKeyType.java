/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="DistinctKeyType" abstract="true">
		<xs:annotation>
			<xs:documentation>DistinctKeyType is an abstract base type which is a special type of region that only defines a distinct region of data or metadata. For each component defined in the region, only a single values is provided. However, the same rules that apply to the general region about unstated components being wild carded apply here as well. Thus, this type can define a distinct full or partial key for data or metadata.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RegionType">
				<xs:sequence>
					<xs:element name="KeyValue" type="DinstinctKeyValueType"  maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="include" type="xs:boolean" use="optional" fixed="true">
					<xs:annotation>
						<xs:documentation>The include attribute has a fixed value of true for a distinct key, since such a key is always assumed to identify existing data or metadata.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:anyAttribute namespace="##local"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DistinctKeyType extends RegionType {

    public DistinctKeyType(List<ComponentValueSetType> attrs, List<DistinctKeyValueType> keys) {
        super(toCVS(keys),attrs,true);
    }
    public DistinctKeyType(List<ComponentValueSetType> attrs, List<DistinctKeyValueType> keys,boolean include) {
        super(toCVS(keys),attrs,include);
    }
    private static List<ComponentValueSetType> toCVS(List<DistinctKeyValueType> keys) {
        List<ComponentValueSetType> list = new ArrayList<ComponentValueSetType>(keys.size());
        list.addAll(keys);
        return list;
    }
    public DistinctKeyValueType getDistinctKeyValue(int i) {
        return (DistinctKeyValueType)super.getKeyValue(i);
    }


}
