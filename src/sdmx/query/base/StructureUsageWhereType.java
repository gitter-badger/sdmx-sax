/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.commonreferences.StructureReferenceBaseType;

/**
 *	<xs:complexType name="StructureUsageWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureUsageWhereType is an abstract base type that serves as the basis for a query for a structure usage object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableWhereType">
				<xs:sequence>
					<xs:element name="Structure" type="common:StructureReferenceBaseType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Structure is used to match the structure referenced by a structure usage object. Only structure usages which reference the supplied structure will be returned.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
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
public class StructureUsageWhereType extends MaintainableWhereType {
    private StructureReferenceBaseType structure = null;

    /**
     * @return the structure
     */
    public StructureReferenceBaseType getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(StructureReferenceBaseType structure) {
        this.structure = structure;
    }
    
}
