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
