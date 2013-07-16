/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.StructureUsageTypeCodelistType;

/**
 *	<xs:complexType name="MetadataflowRefType">
		<xs:annotation>
			<xs:documentation>MetadataflowRefType contains a set of reference fields for a metadata flow.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageRefBaseType">
				<xs:attribute name="class" type="StructureUsageTypeCodelistType" use="optional" fixed="Metadataflow"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataflowRefType extends StructureUsageRefBaseType {
    public MetadataflowRefType(){
        super(null,null,null,StructureUsageTypeCodelistType.METADATAFLOW,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
    
}
