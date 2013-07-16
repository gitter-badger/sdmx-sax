/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalCodelistMapRefType">
		<xs:annotation>
			<xs:documentation>LocalCodelistMapRefType contains a set of reference fields for a codelist map locally.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="containerID" type="NestedIDType" use="prohibited"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="CodelistMap"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>	
 * @author James
 */
public class LocalCodelistMapRefType extends LocalIdentifiableRefBaseType {
    public LocalCodelistMapRefType(){
        super(null,null,ObjectTypeCodelistType.CODELISTMAP,PackageTypeCodelistType.MAPPING);
    }
    
}
