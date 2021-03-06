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

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalLevelRefType">
		<xs:annotation>
			<xs:documentation>LocalLevelRefType references a level object where the reference to the hierarchy in which it is contained and the hierarchical codelist which define it are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="Level"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class LocalLevelRef extends LocalIdentifiableRefBase {
    public LocalLevelRef(NestedID containId,NestedID id,PackageTypeCodelistType pack) {
        super(containId,id,ObjectTypeCodelistType.LEVEL,pack);
    }
    
}
