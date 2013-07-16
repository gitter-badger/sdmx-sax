/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;

/**
 *	<xs:complexType name="ItemSchemeRefType">
		<xs:annotation>
			<xs:documentation>ItemSchemeRefType contains a complete set of reference fields for referencing any item scheme. The class and package a required so that the reference is explicit as to the exact object being referenced.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeRefBaseType">
				<xs:attribute name="class" type="ItemSchemeTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ItemSchemeRefType extends ItemSchemeRefBaseType {
    public ItemSchemeRefType(ItemSchemeTypeCodelistType clazz,ItemSchemePackageTypeCodelistType pack) {
        super(null,null,null,clazz,pack);
    }

}
