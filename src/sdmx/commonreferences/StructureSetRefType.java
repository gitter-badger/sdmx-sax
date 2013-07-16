/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="StructureSetRefType">
		<xs:annotation>
			<xs:documentation>StructureSetRefType contains a set of reference fields for a structure set.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="StructureSet"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class StructureSetRefType extends MaintainableRefBaseType {
    public StructureSetRefType(){
        super(null,null,null,MaintainableTypeCodelistType.STRUCTURESET,PackageTypeCodelistType.MAPPING);
    }
    
}
