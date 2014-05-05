/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="RegionType" abstract="true">
		<xs:annotation>
			<xs:documentation>RegionType is an abstract type which defines a generic constraint region. This type can be refined to define regions for data or metadata sets. A region is defined by a collection of key values - each of which a collection of values for a component which disambiguates data or metadata (i.e. dimensions or the target objects of a metadata target). For each region, as collection of attribute values can be provided. Taken together, the key values and attributes serve to identify or describe a subset of a data or metadata set. Finally, the region can flagged as being included or excluded, although this flag only makes sense when the region is used in a particular context.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="KeyValue" type="ComponentValueSetType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>KeyValue contains a reference to a component which disambiguates the data or metadata (i.e. a dimension or target object) and provides a collection of values for the component. The collection of values can be flagged as being inclusive or exclusive to the region being defined. Any key component that is not included is assumed to be wild carded, which is to say that the cube includes all possible values for the un-referenced key components. Further, this assumption applies to the values of the components as well. The values for any given component can only be sub-setted in the region by explicit inclusion or exclusion. For example, a dimension X which has the possible values of 1, 2, 3 is assumed to have all of these values if a key value is not defined. If a key value is defined with an inclusion attribute of true and the values of 1 and 2, the only the values of 1 and 2 for dimension X are included in the definition of the region. If the key value is defined with an inclusion attribute of false and the value of 1, then the values of 2 and 3 for dimension X are included in the definition of the region. Note that any given key component must only be referenced once in the region.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Attribute" type="ComponentValueSetType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Attributes contains a reference to an attribute component (data or metadata) and provides a collection of values for the referenced attribute. This serves to state that for the key which defines the region, the attributes that are specified here have or do not have (depending to the include attribute of the value set) the values provided. It is possible to provide and attribute reference without specifying values, for the purpose of stating the attribute is absent (include = false) or present with an unbounded set of values. As opposed to key components, which are assumed to be wild carded if absent, no assumptions are made about the absence of an attribute. Only attributes which are explicitly stated to be present or absent from the region will be know. All unstated attributes for the set cannot be assumed to absent or present.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
		<xs:attribute name="include" type="xs:boolean" use="optional" default="true">
			<xs:annotation>
				<xs:documentation>The include attribute indicates that the region is to be included or excluded within the context in which it is defined. For example, if the regions is defined as part of a content constraint, the exclude flag would mean the data identified by the region is not present.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:anyAttribute namespace="##local"/>
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
public class RegionType {
     private List<ComponentValueSetType> keyvalues = new ArrayList<ComponentValueSetType>();
     private List<ComponentValueSetType> attributes = new ArrayList<ComponentValueSetType>();
     private boolean include = true; // default==true

     public RegionType(List<ComponentValueSetType> keys, List<ComponentValueSetType> attributes) {
         this.keyvalues=keys;
         this.attributes=attributes;
     }
     public RegionType(List<ComponentValueSetType> keys, List<ComponentValueSetType> attributes,boolean include) {
         this.keyvalues=keys;
         this.attributes=attributes;
         this.include=include;
     }

     public ComponentValueSetType getKeyValue(int i) {
         return keyvalues.get(i);
     }
     public ComponentValueSetType getAttribute(int i) {
         return attributes.get(i);
     }
    public List<ComponentValueSetType> getKeyValues() { return keyvalues; }
    public List<ComponentValueSetType> getAttributes() { return attributes; }



}
