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
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="ConstraintTargetRefType">
		<xs:annotation>
			<xs:documentation>ConstraintTargetRefType contains a reference to a constraint target within a metadata target of a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required" fixed="CONSTRAINT_TARGET"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="ConstraintTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
	
 * @author James
 */

public class ConstraintTargetRef extends ComponentRefBase {
    public ConstraintTargetRef(IDType containId,IDType id){
        super(null,null,null,containId,id,ComponentTypeCodelistType.CONSTRAINTARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
