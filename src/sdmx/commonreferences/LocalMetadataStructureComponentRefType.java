/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.MetadataStructureComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalMetadataStructureComponentRefType">
		<xs:annotation>
			<xs:documentation>LocalMetadataStructureComponentRefType contains the reference fields for referencing any metadata structure component locally. This reference must specify the class of the component being referenced.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="class" type="MetadataStructureComponentTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalMetadataStructureComponentRefType extends LocalComponentListComponentRefBaseType {

    public LocalMetadataStructureComponentRefType(IDType containId,MetadataStructureComponentTypeCodelistType clazz){
        super(containId,null,clazz,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
    
    
}
