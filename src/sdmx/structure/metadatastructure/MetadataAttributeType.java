/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.common.OccurenceType;

/**
 *	<xs:complexType name="MetadataAttributeType">
		<xs:annotation>
			<xs:documentation>MetadataAttributeType describes the structure of a metadata attribute. The metadata attribute takes its semantic, and in some cases it representation, from its concept identity. A metadata attribute may be coded (via the local representation), uncoded (via the text format), or take no value. In addition to this value, the metadata attribute may also specify subordinate metadata attributes. If a metadata attribute only serves the purpose of containing subordinate metadata attributes, then the isPresentational attribute should be used. Otherwise, it is assumed to also take a value. If the metadata attribute does take a value, and a representation is not defined, it will be inherited from the concept it takes its semantic from. The optional id on the metadata attribute uniquely identifies it within the metadata structured definition. If this id is not supplied, its value is assumed to be that of the concept referenced from the concept identity. Note that a metadata attribute (as identified by the id attribute) definition  must be unique across the entire metadata structure definition (including target identifier, identifier component, and report structure ids). A metadata attribute may be used in multiple report structures and at different levels, but the content (value and/or child metadata attributes and their cardinality) of the metadata attribute cannot change.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:extension base="MetadataAttributeBaseType">
				<xs:sequence>
					<xs:element ref="MetadataAttribute" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="minOccurs" type="xs:nonNegativeInteger" default="1">
					<xs:annotation>
						<xs:documentation>The minOccurs attribute indicates the minimum number of times this metadata attribute can occur within its parent object.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maxOccurs" type="common:OccurenceType" default="1">
					<xs:annotation>
						<xs:documentation>The maxOccurs attribute indicates the maximum number of times this metadata attribute can occur within its parent object.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="isPresentational" type="xs:boolean" use="optional" default="false">
					<xs:annotation>
						<xs:documentation>The isPresentational attribute indicates whether the metadata attribute should allow for a value. A value of true, meaning the metadata attribute is presentational means that the attribute only contains child metadata attributes, and does not contain a value. If this attribute is not set to true, and a representation (coded or uncoded) is not defined, then the representation of the metadata attribute will be inherited from the concept from which it takes its identity.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
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
public class MetadataAttributeType extends MetadataAttributeBaseType {
    private OccurenceType maxOccurs = OccurenceType.ONE;
    private Boolean isPresentational = false;

    private List<MetadataAttribute> attributes = null;
    /**
     * @return the maxOccurs
     */
    public OccurenceType getMaxOccurs() {
        return maxOccurs;
    }

    /**
     * @param maxOccurs the maxOccurs to set
     */
    public void setMaxOccurs(OccurenceType maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    /**
     * @return the isPresentational
     */
    public Boolean isPresentational() {
        return isPresentational;
    }

    /**
     * @param isPresentational the isPresentational to set
     */
    public void setPresentational(Boolean isPresentational) {
        this.isPresentational = isPresentational;
    }

    /**
     * @return the attributes
     */
    public List<MetadataAttribute> getMetadataAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setMetadataAttributes(List<MetadataAttribute> attributes) {
        this.attributes = attributes;
    }
}
