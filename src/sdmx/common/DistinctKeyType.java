/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
