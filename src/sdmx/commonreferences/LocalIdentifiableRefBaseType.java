/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="LocalIdentifiableRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalIdentifiableRefBaseType is an abstract base type which provides a local reference to any identifiable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="prohibited"/>
				<xs:attribute name="maintainableParentID" type="IDType" use="prohibited"/>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="prohibited"/>
				<xs:attribute name="containerID" type="NestedIDType" use="optional"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="prohibited"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="true"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional"/>
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
public class LocalIdentifiableRefBaseType extends RefBaseType {
       public LocalIdentifiableRefBaseType(NestedIDType containId,NestedIDType id, ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
           super(null,id,null,null,null,containId,true,obs,pack);
       }
}
