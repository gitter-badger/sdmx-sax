/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.StructureTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataStructureRefType">
		<xs:annotation>
			<xs:documentation>DataStructureRefType contains a set of reference fields for a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureRefBaseType">
				<xs:attribute name="class" type="StructureTypeCodelistType" use="optional" fixed="DataStructure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
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
public class DataStructureRef extends StructureRefBase {
    public DataStructureRef(NestedNCNameID agency,IDType id,Version ver) {
        super(agency,id,ver,StructureTypeCodelistType.DATASTRUCTURE,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }

}
