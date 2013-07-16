/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.TargetObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalTargetObjectRefType">
		<xs:annotation>
			<xs:documentation>LocalTargetObjectRefType contains the reference fields for referencing a target object locally.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentRefBaseType">
				<xs:attribute name="class" type="TargetObjectTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalTargetObjectRefType extends LocalComponentRefBaseType {
    public LocalTargetObjectRefType(TargetObjectTypeCodelistType clazz){
        super(null,null,clazz,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
    
}
