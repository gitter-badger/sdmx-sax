/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="StructureOrUsageRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureOrUsageRefBaseType is an abstract base type for referencing a structure or structure usage.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="optional" default="1.0"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="StructureOrUsageTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional"/>
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

public class StructureOrUsageRefBaseType extends MaintainableRefBaseType {
   public StructureOrUsageRefBaseType(NestedNCNameIDType agencyId,IDType id,VersionType vers,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(agencyId,id,vers,obs,pack);
   }
}
