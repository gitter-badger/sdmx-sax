/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="HierarchyRefType">
		<xs:annotation>
			<xs:documentation>HierarchyRefType is type which references a hierarchy from within a hierarchical codelist. Reference fields are required for both the hierarchy and the codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="Hierarchy"/>
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
public class HierarchRef extends ChildObjectRefBase {
    public HierarchRef(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.HIERARCHY,PackageTypeCodelistType.CODELIST);
    }
    
}
