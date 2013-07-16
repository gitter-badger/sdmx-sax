/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="StructureMapRefType">
		<xs:annotation>
			<xs:documentation>StructureMapRefType contains fields for referencing a structure map within a structure set.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="StructureMap"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class StructureMapRefType extends ChildObjectRefBaseType {
    public StructureMapRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.STRUCTUREMAP,PackageTypeCodelistType.MAPPING);
    }
}
