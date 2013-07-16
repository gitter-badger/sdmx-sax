/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.OrganisationSchemeTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="OrganisationSchemeRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>OrganisationSchemeRefBaseType contains a set of reference fields for an organisation scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeRefBaseType">
				<xs:attribute name="class" type="OrganisationSchemeTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="base"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 * 
 */
public class OrganisationSchemeRefBaseType extends ItemSchemeRefBaseType {

    public OrganisationSchemeRefBaseType(IDType id,OrganisationSchemeTypeCodelistType clazz) {
        // Waiting for ItemSchemePackageTypeCodelistType.BASE
        super(null,id,null,clazz,ItemSchemePackageTypeCodelistType.BASE);
    }
}
