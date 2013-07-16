/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.common.ObsDimensionsCodeType;

/**
 *	<xs:complexType name="CategoryRefType">
		<xs:annotation>
			<xs:documentation>CategoryRefType references a category from within a category scheme. Reference fields are required for both the scheme and the item.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the category scheme in which the category being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the category scheme in which the category being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Category"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CategoryRefType extends ItemRefBaseType {
    public CategoryRefType(NestedNCNameIDType agencyId,NestedIDType id,IDType mainParent,VersionType pvers,ItemTypeCodelistType clazz,ItemSchemePackageTypeCodelistType pack) {
        super(agencyId,mainParent,pvers,id,clazz,pack);
    }
}
