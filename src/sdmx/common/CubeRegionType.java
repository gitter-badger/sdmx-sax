/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.List;

/**
 *	<xs:complexType name="CubeRegionType">
		<xs:annotation>
			<xs:documentation>CubeRegionType defines the structure of a data cube region. This is based on the abstract RegionType and simply refines the key and attribute values to conform with what is applicable for dimensions and attributes, respectively. See the documentation of the base type for more details on how a region is defined.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RegionType">
				<xs:sequence>
					<xs:element name="KeyValue" type="CubeRegionKeyType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="Attribute" type="AttributeValueSetType" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
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
public class CubeRegionType extends RegionType {
        private List<CubeRegionKeyType> keyValues = null;
        private List<AttributeValueSetType> attributes = null;

        public CubeRegionType(List<CubeRegionKeyType> values,List<AttributeValueSetType> attrs){
            super(null,null);
            this.keyValues=values;
            this.attributes=attrs;
        }

}
