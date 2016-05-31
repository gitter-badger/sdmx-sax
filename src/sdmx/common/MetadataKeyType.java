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

import sdmx.commonreferences.IDType;
import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="MetadataKeyType">
		<xs:annotation>
			<xs:documentation>MetadataKeyType is a region which defines a distinct full or partial metadata key. The key consists of a set of values, each referencing a target object for the metadata target referenced in the metadataTarget attribute, which must be defined in the report structure referenced in the report attribute. Each target object can be assigned a single value. If an target object from the reference metadata target is not included in this key, the value of that is assumed to be all known objects for a reference target object, all possible keys for a key descriptor values target object, or all dates for report period target object. The purpose of this key reference a metadata conforming to a particular report structure for given object or set of objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DistinctKeyType">
				<xs:sequence>
					<xs:element name="KeyValue" type="MetadataKeyValueType" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="report" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The report attribute is required and holds the identifier of the report structure which the reference metadata being defined by this key is based on.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="metadataTarget" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The metadataTarget attribute is required and identifies the metadata target for the report structure which this key is based upon. Note that a report structure can have multiple metadata targets, so to properly determine the object or objects for which the key applies, the proper metadata target must be identified.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
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
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class MetadataKeyType extends DistinctKeyType {
    private IDType report = null; // Required
    private IDType metadataTarget = null; //Required
    public MetadataKeyType(List<MetadataKeyValueType> keyValues,List<ComponentValueSetType> attrs,boolean include,IDType report,IDType target) {
        super(attrs,toDVT(keyValues),include);
        this.report=report;
        this.metadataTarget=target;
    }
    private static List<DistinctKeyValueType> toDVT(List<MetadataKeyValueType> keys) {
        List<DistinctKeyValueType> list = new ArrayList<DistinctKeyValueType>(keys.size());
        list.addAll(keys);
        return list;
    }
    public MetadataKeyValueType getMetadataKeyValueType(int i) {
        return (MetadataKeyValueType)super.getDistinctKeyValue(i);
    }

    public int getMetadataKeyValueTypeSize() { return super.getKeyValues().size(); }
}
