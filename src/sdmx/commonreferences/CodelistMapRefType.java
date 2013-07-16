/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="CodelistMapRefType">
		<xs:annotation>
			<xs:documentation>CodelistMapRefType contains a set of reference fields for a codelist map.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="CodelistMap"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>	
 * @author James
 */
public class CodelistMapRefType extends ChildObjectRefBaseType {
    public CodelistMapRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.CODELISTMAP,PackageTypeCodelistType.MAPPING);
    }

}
