/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="GroupKeyDescriptorRefType">
		<xs:annotation>
			<xs:documentation>GroupKeyDescriptorRefType contains a reference to a group key descriptor within a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="GroupDimensionDescriptor"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class GroupKeyDescriptorRefType extends ComponentListRefBaseType {
    public GroupKeyDescriptorRefType(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.GROUPDIMENSIONDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
