/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NCNameID;

/**
 *	<xs:complexType name="ComponentBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentBaseType is an abstract type that only serves the purpose of forming the base for the actual ComponentType. It only restricts the format of the id attribute to the NCNameIDType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="IdentifiableType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="optional">
					<xs:annotation>
						<xs:documentation>The id attribute holds an explicit identification of the component. If this identifier is not supplied, then it is assumed to be the same as the identifier of the concept referenced from the concept identity. Because structures require that every component be given a unique identifier, it may be necessary to assign an explicit identifier when more than one component in a structure reference concepts with same identifier. It is important to note that this applies strictly to the identifier of concept and not the URN. Therefore if two concepts with the same identifier from different concept schemes are referenced in the same structure, one of the components will have to provide a unique explicit identifier. The type of this identifier is restricted to the common:NCNameIDType. This is necessary, since component identifiers are used to create XML elements and attributes in data and metadata structure specific schemas and therefore must be compliant with the NCName type in XML Schema (see common:NCNameIDType for further details).</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class ComponentBaseType extends IdentifiableType {

}
