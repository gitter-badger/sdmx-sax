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
import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
public class AttributeDescriptorRefType extends ComponentListRefBaseType {
    public AttributeDescriptorRefType(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.ATTRIBUTEDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
}
