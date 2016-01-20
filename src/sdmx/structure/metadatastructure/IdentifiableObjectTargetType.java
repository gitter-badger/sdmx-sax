/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="IdentifiableObjectTargetType">
		<xs:annotation>
			<xs:documentation>IdentifiableObjectTargetType defines the structure of an identifiable target object. The identifiable target object has a fixed representation of a reference and can specify a local representation of any item scheme for the purpose of restricting which items may be referenced. The identifiable object target must specify the object type which the target object is meant to reference.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableObjectTargetBaseType">
				<xs:attribute name="objectType" type="common:ObjectTypeCodelistType" use="required"/>
			</xs:extension>
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
public class IdentifiableObjectTargetType extends IdentifiableObjectTargetBaseType {
    private ObjectTypeCodelistType objectType = null;

    /**
     * @return the objectType
     */
    public ObjectTypeCodelistType getObjectType() {
        return objectType;
    }

    /**
     * @param objectType the objectType to set
     */
    public void setObjectType(ObjectTypeCodelistType objectType) {
        this.objectType = objectType;
    }
    
}
