/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="MetadataTargetRefType">
		<xs:annotation>
			<xs:documentation>MetadataTargetRefType contains a reference to a metadata target within a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="MetadataTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataTargetRefType extends ComponentListRefBaseType {
    public MetadataTargetRefType(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.METADATATARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
