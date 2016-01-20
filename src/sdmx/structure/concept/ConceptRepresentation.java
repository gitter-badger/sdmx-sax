/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

import sdmx.structure.base.BasicComponentTextFormatType;
import sdmx.structure.base.RepresentationType;

/**
 *	<xs:complexType name="ConceptRepresentation">
		<xs:annotation>
			<xs:documentation>ConceptRepresentation defines the core representation that are allowed for a concept. The text format allowed for a concept is that which is allowed for any non-target object component.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RepresentationType">
				<xs:choice>
					<xs:element name="TextFormat" type="BasicComponentTextFormatType"/>
					<xs:sequence>
						<xs:element name="Enumeration" type="common:CodelistReferenceType">
							<xs:annotation>
								<xs:documentation>Enumeration references a codelist which enumerates the possible values that can be used as the representation of this concept.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="EnumerationFormat" type="CodededTextFormatType" minOccurs="0"/>
					</xs:sequence>
				</xs:choice>
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

public class ConceptRepresentation extends RepresentationType {
    BasicComponentTextFormatType textFormat = null;
    
}
