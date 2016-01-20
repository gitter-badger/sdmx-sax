/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import sdmx.commonreferences.StructureReferenceBase;

/**
 *	<xs:complexType name="StructureUsageType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureUsageType is an abstract base type for all structure usages. It contains a reference to a structure. Concrete instances of this type should restrict the type of structure referenced.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableType">
				<xs:sequence>
					<xs:element name="Structure" type="common:StructureReferenceBaseType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Structure references the structure (data structure or metadata structure definition) which the structure usage is based upon. Implementations will have to refine the type to use a concrete structure reference (i.e. either a data structure or metadata structure definition reference).</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:extension>
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
public class StructureUsageType extends MaintainableType {
    private StructureReferenceBase structure = null;

    /**
     * @return the structure
     */
    public StructureReferenceBase getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(StructureReferenceBase structure) {
        this.structure = structure;
    }
}
