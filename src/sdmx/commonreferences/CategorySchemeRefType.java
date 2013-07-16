/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;

/**
 *	<xs:complexType name="CategorySchemeRefType">
		<xs:annotation>
			<xs:documentation>CategorySchemeRefType provides a reference to a category scheme via a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeRefBaseType">
				<xs:attribute name="class" type="ItemSchemeTypeCodelistType" use="optional" fixed="CategoryScheme"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
class CategorySchemeRefType extends ItemSchemeRefBaseType {
    public CategorySchemeRefType(ItemSchemeTypeCodelistType clazz,ItemSchemePackageTypeCodelistType pack) {
        super(null,null,null,clazz,pack);
    }
}
