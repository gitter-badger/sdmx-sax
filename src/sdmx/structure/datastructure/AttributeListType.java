/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.Annotations;
import sdmx.commonreferences.IDType;
import sdmx.structure.base.Component;
import sdmx.structure.base.ComponentListType;
import sdmx.structure.datastructure.AttributeType;
import sdmx.structure.datastructure.AttributeBaseType;

/**
 *	<xs:complexType name="AttributeListBaseType" abstract="true">
		<xs:annotation>
				<xs:documentation>AttributeListBaseType is an abstract base type used as the basis for the AttributeListType.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:restriction base="ComponentListType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:IDType" use="optional" fixed="AttributeDescriptor">
					<xs:annotation>
						<xs:documentation>The id attribute is provided in this case for completeness. However, its value is fixed to AttributeDescriptor.</xs:documentation>
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
public class AttributeListType extends AttributeListBaseType {
   List<AttributeType> attributes = new ArrayList<AttributeType>();
    
   public List<AttributeType> getAttributes() {
       return attributes;
   }
   
   public void setAttributes(List<AttributeType> at) {
       this.attributes=at;
   }
   
   public AttributeType getAttribute(int i) {
       return attributes.get(i);
   }
   public int size() { return attributes.size();}
}
