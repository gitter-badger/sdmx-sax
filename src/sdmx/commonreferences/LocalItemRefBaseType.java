/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalItemRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalItemRefBaseType is an abstract base type which provides a local reference to a item object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="containerID" type="NestedIDType" use="prohibited"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalItemRefBaseType extends LocalIdentifiableRefBaseType {
       public LocalItemRefBaseType(NestedIDType id, ItemTypeCodelistType obs,ItemSchemePackageTypeCodelistType pack) {
           super(null,id,obs,pack);
       }

}
