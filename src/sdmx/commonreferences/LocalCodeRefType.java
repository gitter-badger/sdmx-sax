/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalCodeRefType">
		<xs:annotation>
			<xs:documentation>LocalCodeRefType references a code locally where the references to the codelist which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Code"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalCodeRefType extends LocalItemRefBaseType {
       public LocalCodeRefType(NestedIDType id, ItemTypeCodelistType obs,ItemSchemePackageTypeCodelistType pack) {
           super(id,obs,pack);
       }
}
