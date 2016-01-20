/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class LocalConceptRef extends LocalItemRefBase {
    public LocalConceptRef(IDType id, ItemTypeCodelistType clazz, ItemSchemePackageTypeCodelistType pack){
        super(id,clazz,pack);
    }
}
