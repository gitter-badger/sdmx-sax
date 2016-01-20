/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.MetadataStructureComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalMetadataStructureComponentRefType">
		<xs:annotation>
			<xs:documentation>LocalMetadataStructureComponentRefType contains the reference fields for referencing any metadata structure component locally. This reference must specify the class of the component being referenced.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="class" type="MetadataStructureComponentTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
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
public class LocalMetadataStructureComponentRef extends LocalComponentListComponentRefBase {

    public LocalMetadataStructureComponentRef(IDType containId,MetadataStructureComponentTypeCodelistType clazz){
        super(containId,null,clazz,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
    
    
}
