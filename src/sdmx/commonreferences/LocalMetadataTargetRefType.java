/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalMetadataTargetRefType">
		<xs:annotation>
			<xs:documentation>LocalMetadataTargetRefType contains a local reference to a metadata target object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListRefBaseType">
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="MetadataTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalMetadataTargetRefType extends LocalComponentListRefBaseType {
    public LocalMetadataTargetRefType(IDType id){
        super(id,ComponentListTypeCodelistType.METADATATARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
