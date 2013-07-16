/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalGroupKeyDescriptorRefType">
		<xs:annotation>
			<xs:documentation>LocalGroupKeyDescriptorRefType contains a local reference to a group key descriptor.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListRefBaseType">
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="GroupDimensionDescriptor"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalGroupKeyDescriptorRefType extends LocalComponentListRefBaseType {
    public LocalGroupKeyDescriptorRefType(IDType id){
        super(id,ComponentListTypeCodelistType.GROUPDIMENSIONDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
}
