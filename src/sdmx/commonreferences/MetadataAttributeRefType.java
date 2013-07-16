/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="MetadataAttributeRefType">
		<xs:annotation>
			<xs:documentation>MetadataAttributeRefType contains a reference to a metadata attribute within a report structure in a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="MetadataAttribute"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataAttributeRefType extends ComponentRefBaseType {
    
    public MetadataAttributeRefType(IDType containId,NestedIDType id){
        super(null,null,null,containId,id,ComponentTypeCodelistType.METADATAATTRIBUTE,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
    
}
