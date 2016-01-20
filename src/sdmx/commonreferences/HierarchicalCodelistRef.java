/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="HierarchicalCodelistRefType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodelistRefType contains a set of reference fields for a hierarchical codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="HierarchicalCodelist"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="codelist"/>
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
public class HierarchicalCodelistRef extends MaintainableRefBase {
     public HierarchicalCodelistRef(NestedNCNameID agencyId,IDType id,Version vers) {
         super(agencyId,id,vers,MaintainableTypeCodelistType.HIERARCHICALCODELIST,ItemSchemePackageTypeCodelistType.CODELIST);
     }
}
