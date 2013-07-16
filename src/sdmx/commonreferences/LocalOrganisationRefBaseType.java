/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalOrganisationRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalOrganisationRefBaseType is an abstract base type that references an organisation locally where the reference to the organisation scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="base"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalOrganisationRefBaseType extends LocalItemRefBaseType {
    public LocalOrganisationRefBaseType(IDType id,OrganisationTypeCodelistType clazz) {
        super(id,clazz,ItemSchemePackageTypeCodelistType.BASE);
    }
    public LocalOrganisationRefBaseType(IDType id) {
        super(id,null,ItemSchemePackageTypeCodelistType.BASE);
    }
}
