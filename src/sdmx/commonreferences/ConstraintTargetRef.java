/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="ConstraintTargetRefType">
		<xs:annotation>
			<xs:documentation>ConstraintTargetRefType contains a reference to a constraint target within a metadata target of a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required" fixed="CONSTRAINT_TARGET"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="ConstraintTarget"/>
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
public class ConstraintTargetRef extends ComponentRefBase {
    public ConstraintTargetRef(IDType containId,IDType id){
        super(null,null,null,containId,id,ComponentTypeCodelistType.CONSTRAINTARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
