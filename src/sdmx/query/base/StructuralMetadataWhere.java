/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

/**
 *	<xs:element name="StructuralMetadataWhere" type="MaintainableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructuralMetadataWhere is an abstract substitution head that forms the basis of any structural metadata query's details. This contains the actual parameters to be matched. These parameters are implicitly joined by an "and" connector (i.e. each of the parameters must be matched in order to satisfy the query). If it is necessary to supply "or" conditions for a parameter, this should be done by supplying multiple queries.</xs:documentation>
		</xs:annotation>
	</xs:element>
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
public class StructuralMetadataWhere extends MaintainableWhereType {
    
}
