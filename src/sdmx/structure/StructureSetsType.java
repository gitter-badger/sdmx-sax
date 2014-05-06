/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *<xs:complexType name="StructureSetsType">
		<xs:annotation>
			<xs:documentation>StructureSetsType describes the structure of the structure sets container. It contains one or more structure set, which can be explicitly detailed or referenced from an external structure document or registry service.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="StructureSet" type="StructureSetType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>StructureSet provides the details or a structure set, which allows components in one structure, structure usage, or item scheme to be mapped to components in another structural component of the same type.</xs:documentation>
				</xs:annotation>
				<xs:unique name="StructureSetUniqueCategorySchemeMap">
					<xs:selector xpath="structure:CategorySchemeMap"/>
					<xs:field xpath="@id"/>
				</xs:unique>
				<xs:unique name="StructureSetUniqueCodelistMap">
					<xs:selector xpath="structure:CodelistMap"/>
					<xs:field xpath="@id"/>
				</xs:unique>
				<xs:unique name="StructureSetUniqueConceptsMap">
					<xs:selector xpath="structure:ConceptsMap"/>
					<xs:field xpath="@id"/>
				</xs:unique>
				<xs:unique name="StructureSetUniqueOrganisationSchemeMap">
					<xs:selector xpath="structure:OrganisationSchemeMap"/>
					<xs:field xpath="@id"/>
				</xs:unique>
				<xs:unique name="StructureSetUniqueStructureMap">
					<xs:selector xpath="structure:StructureMap"/>
					<xs:field xpath="@id"/>
				</xs:unique>
			</xs:element>
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
public class StructureSetsType {
    private List<StructureSetType> structureSets = new ArrayList<StructureSetType>();

    /**
     * @return the structureSets
     */
    public List<StructureSetType> getStructureSets() {
        return structureSets;
    }

    /**
     * @param structureSets the structureSets to set
     */
    public void setStructureSets(List<StructureSetType> structureSets) {
        this.structureSets = structureSets;
    }
}
