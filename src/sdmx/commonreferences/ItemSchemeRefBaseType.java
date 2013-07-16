/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;

/**
 *	<xs:complexType name="ItemSchemeRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemSchemeRefBaseType is an abstract base type for referencing an item scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="optional" default="1.0"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="ItemSchemeTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ItemSchemeRefBaseType extends MaintainableRefBaseType {
    public ItemSchemeRefBaseType(NestedNCNameIDType agencyId,IDType id,VersionType vers,ItemSchemeTypeCodelistType clazz,ItemSchemePackageTypeCodelistType pack) {
        super(agencyId,id,vers,clazz,pack);
    }
}
