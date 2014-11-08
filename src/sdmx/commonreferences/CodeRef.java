/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import org.sdmx.resources.sdmxml.schemas.v21.common.NestedNCNameIDType;
import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="CodeRefType">
		<xs:annotation>
			<xs:documentation>CodeRefType references a code from within a codelist. Reference fields are required for both the scheme and the item.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the codelist in which the code being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the codelist in which the code being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Code"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="codelist"/>
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
public class CodeRef extends ItemRefBase {
    public CodeRef(NestedNCNameID agency,IDType mparent,Version vpar, NestedID id) {
         super(agency,mparent,vpar,id,ItemTypeCodelistType.CODE,ItemSchemePackageTypeCodelistType.CODELIST);
    }
}
