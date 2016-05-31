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
