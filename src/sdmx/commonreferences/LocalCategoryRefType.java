/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalCategoryRefType">
		<xs:annotation>
			<xs:documentation>LocalCategoryRefType references a category locally where the references to the category scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemRefBaseType">
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Category"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalCategoryRefType extends LocalItemRefBaseType {
       public LocalCategoryRefType(ItemTypeCodelistType obs,ItemSchemePackageTypeCodelistType pack) {
           super(null,obs,pack);
       }
}
