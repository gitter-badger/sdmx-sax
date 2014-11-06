/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.StructureTypeCodelistType;

/**
 *	<xs:complexType name="MetadataStructureRefType">
		<xs:annotation>
			<xs:documentation>MetadataStructureRefType contains a set of reference fields for a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureRefBaseType">
				<xs:attribute name="class" type="StructureTypeCodelistType" use="optional" fixed="MetadataStructure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
*/
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */

/*
 * @author James
 *  Does this class need to have more fields? it's supposed to reference a Metadataflow, but it's restricted to just a class and package
 *  might need to clarify something here..
 */
public class MetadataStructureRef extends StructureRefBase {
    public MetadataStructureRef(IDType id){
        super(null,id,null,StructureTypeCodelistType.METADATASTRUCTURE,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
