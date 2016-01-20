/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
public class LocalLevelRef extends LocalIdentifiableRefBase {
    public LocalLevelRef(NestedID containId,NestedID id,PackageTypeCodelistType pack) {
        super(containId,id,ObjectTypeCodelistType.LEVEL,pack);
    }
    
}
