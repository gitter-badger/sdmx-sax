/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="HierarchyRefType">
		<xs:annotation>
			<xs:documentation>HierarchyRefType is type which references a hierarchy from within a hierarchical codelist. Reference fields are required for both the hierarchy and the codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="Hierarchy"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class HierarchRefType extends ChildObjectRefBaseType {
    public HierarchRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.HIERARCHY,PackageTypeCodelistType.CODELIST);
    }
    
}
