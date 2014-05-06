/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import org.sdmx.resources.sdmxml.schemas.v21.query.StructureReturnDetailType;

/**
 *	<xs:complexType name="StructureReturnDetailsBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureReturnDetailsBaseType is an abstract base type which forms the basis of StructureReturnDetailsType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReturnDetailsBaseType">
				<xs:attribute name="detail" type="StructureReturnDetailType" default="Full">
					<xs:annotation>
						<xs:documentation>The detail attribute is used to indicate whether the response to the query should return the full details of matched objects, or just a subset of the information should be returned. A value of "Full" indicates that the full details of all matched objects should be returned. A value of "CompleteStub" indicates that the identification information, name, description, and annotations for the matched object should be returned. A value of "Stub" indicates that just the identification information and name should be returned for the matched objects. Note that this applies only to the object(s) matched by the query parameters. The References element has a separate field for indicating the level of detail returned for referenced objects.</xs:documentation>
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
public class StructureReturnDetailsBaseType extends ReturnDetailsBaseType {
    private StructureReturnDetailType detail = null;
}
