/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:complexType name="StructuralMetadataQueryType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureWhereQueryType is an abstract base type that serves as the basis for any structural metadata query. Concrete instances of this type are implied to be an and-query. A structural object will be returned for any object where all of the conditions are met.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="ReturnDetails" type="StructureReturnDetailsType"/>
			<xs:element ref="StructuralMetadataWhere"/>
		</xs:sequence>
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
public class StructuralMetadataQueryType {
    StructureReturnDetailsType returnDetails = null;
    StructuralMetadataWhere query = null;
}
