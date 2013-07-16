/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="KeyDescriptorRefType">
		<xs:annotation>
			<xs:documentation>KeyDescriptorRefType contains a reference to the key descriptor within a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required" fixed="DIMENSION_DESCRIPTOR"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="DimensionDescriptor"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class KeyDescriptorRefType extends ComponentListRefBaseType {
    public KeyDescriptorRefType(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.DIMENSIONDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
     }
    
}
