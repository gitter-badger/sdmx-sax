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

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;

/**
 *
 * <xs:complexType name="LocalConceptRefType">
*		<xs:annotation>
*			<xs:documentation>LocalConceptRefType references a concept locally where the references to the concept scheme which defines it is provided elsewhere.</xs:documentation>
*		</xs:annotation>
*		<xs:complexContent>
*			<xs:restriction base="LocalItemRefBaseType">
*				<xs:attribute name="id" type="IDType" use="required"/>
*				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Concept"/>
*				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="conceptscheme"/>
*			</xs:restriction>
*		</xs:complexContent>
*	</xs:complexType>
*
 * @author James
 */

public class LocalConceptRef extends LocalItemRefBase {
    public LocalConceptRef(IDType id, ItemTypeCodelistType clazz, ItemSchemePackageTypeCodelistType pack){
        super(id,clazz,pack);
    }
}
