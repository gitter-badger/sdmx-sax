/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalItemRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalItemRefBaseType is an abstract base type which provides a local reference to a item object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="containerID" type="NestedIDType" use="prohibited"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional"/>
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
public class LocalItemRefBase extends LocalIdentifiableRefBase {
       public LocalItemRefBase(NestedID id, ItemTypeCodelistType obs,ItemSchemePackageTypeCodelistType pack) {
           super(null,id,obs,pack);
       }

}