/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="AttributeDescriptorRefType">
		<xs:annotation>
			<xs:documentation>AttributeDescriptorRefType contains a reference to the attribute descriptor within a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required" fixed="ATTRIBUTE_DESCRIPTOR"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="AttributeDescriptor"/>
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
import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
public class AttributeDescriptorRef extends ComponentListRefBase {
    public AttributeDescriptorRef(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.ATTRIBUTEDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
}
