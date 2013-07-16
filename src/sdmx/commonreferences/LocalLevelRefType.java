/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalLevelRefType">
		<xs:annotation>
			<xs:documentation>LocalLevelRefType references a level object where the reference to the hierarchy in which it is contained and the hierarchical codelist which define it are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="Level"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalLevelRefType extends LocalIdentifiableRefBaseType {
    public LocalLevelRefType(NestedIDType containId,NestedIDType id,PackageTypeCodelistType pack) {
        super(containId,id,ObjectTypeCodelistType.LEVEL,pack);
    }
    
}
