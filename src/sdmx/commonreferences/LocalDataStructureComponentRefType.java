/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.DataStructureComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalDataStructureComponentRefType">
		<xs:annotation>
			<xs:documentation>LocalDataStructureComponentRefType contains the reference fields for referencing any data structure component locally. This reference must specify the class of the component being referenced.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="prohibited"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="DataStructureComponentTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
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
public class LocalDataStructureComponentRefType extends LocalComponentListComponentRefBaseType {
    public LocalDataStructureComponentRefType(IDType id,DataStructureComponentTypeCodelistType clazz){
        super(null,id,clazz,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
