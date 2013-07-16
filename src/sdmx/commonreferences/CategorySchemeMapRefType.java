/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="CategorySchemeMapRefType">
		<xs:annotation>
			<xs:documentation>CategorySchemeMapRefType contains a set of reference fields for a category scheme map.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="CategorySchemeMap"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>	
 * @author James
 */
public class CategorySchemeMapRefType extends ChildObjectRefBaseType {
    public CategorySchemeMapRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.CATEGORYSCHEMEMAP,PackageTypeCodelistType.MAPPING);
    }
    
}
