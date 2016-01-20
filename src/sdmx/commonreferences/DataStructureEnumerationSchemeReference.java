/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataStructureEnumerationSchemeReferenceType">
		<xs:annotation>
			<xs:documentation>DataStructureEnumerationSchemeReferenceType is a type for referencing any type of item scheme that is allowable as the enumeration of the representation of a data structure definition component. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataStructureEnumerationSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
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
public class DataStructureEnumerationSchemeReference extends ItemSchemeReference {
    public DataStructureEnumerationSchemeReference(DataStructureEnumerationSchemeRef ref, anyURI uri){
        super(ref,uri);
    }
    public DataStructureEnumerationSchemeReference(anyURI uri){
        super(uri);
    }
}
