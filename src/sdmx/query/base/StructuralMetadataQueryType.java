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
public class StructuralMetadataQueryType {
    StructureReturnDetailsType returnDetails = null;
    StructuralMetadataWhere query = null;
}
