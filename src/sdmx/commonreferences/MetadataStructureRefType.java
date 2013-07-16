/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.StructureTypeCodelistType;

/**
 *	<xs:complexType name="MetadataStructureRefType">
		<xs:annotation>
			<xs:documentation>MetadataStructureRefType contains a set of reference fields for a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureRefBaseType">
				<xs:attribute name="class" type="StructureTypeCodelistType" use="optional" fixed="MetadataStructure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 *  Does this class need to have more fields? it's supposed to reference a Metadataflow, but it's restricted to just a class and package
 *  might need to clarify something here..
 */
public class MetadataStructureRefType extends StructureRefBaseType {
    public MetadataStructureRefType(IDType id){
        super(null,id,null,StructureTypeCodelistType.METADATASTRUCTURE,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
