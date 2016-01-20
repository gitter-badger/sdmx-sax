/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="HierarchicalCodeRefType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodeRefType references a code from within a hierarchical codelist. Reference fields are required for both the code and the codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the hierarchical codelist in which the code being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the hierarchical codelist in which the code being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="containerID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The containerID references the hierarchy which contains the code being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="HierarchicalCode"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
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
public class HierarchicalCodeRef extends ContainerChildObjectRefBase {
    public HierarchicalCodeRef(IDType maintainableParentID,Version maintainableParentVersion,IDType containerID) {
        super((NestedNCNameID)null,maintainableParentID,maintainableParentVersion,null,containerID,ObjectTypeCodelistType.HIERARCHICALCODE,PackageTypeCodelistType.CODELIST);
    }
}
