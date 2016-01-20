/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.DimensionTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalDimensionRefType">
		<xs:annotation>
			<xs:documentation>LocalDimensionRefType contains the reference fields for referencing a dimension locally.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="DimensionTypeCodelistType" use="optional" default="Dimension">
					<xs:annotation>
						<xs:documentation>The class attribute is optional and provided a default value of Dimension. It is strongly recommended that if the time or measure dimension is referenced, that the proper value be set for this field. However, this is not absolutely necessary since all data structure definition components must have a unique identifier within the scope of the entire data structure. It does, however, allow systems which will treat such a reference as a URN to easily construct the URN without having to verify the object class of the referenced dimension.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
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
public class LocalDimensionRef extends LocalComponentRefBase {
    public LocalDimensionRef(IDType id){
        super(null,id,DimensionTypeCodelistType.DIMENSION,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
