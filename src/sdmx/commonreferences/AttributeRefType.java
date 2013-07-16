/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="AttributeRefType">
		<xs:annotation>
			<xs:documentation>AttributeRefType contains a reference to an attribute within a data structure definition. Note that since there is only one attribute descriptor, the container reference fields are prohibited.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="prohibited"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="Attribute"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class AttributeRefType extends ComponentRefBaseType {
    public AttributeRefType(IDType id){
        super(null,null,null,null,id,ComponentTypeCodelistType.ATTRIBUTE,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
