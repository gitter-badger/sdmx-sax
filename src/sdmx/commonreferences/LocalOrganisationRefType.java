/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalOrganisationRefType">
		<xs:annotation>
			<xs:documentation>LocalOrganisationRefType references an organisation locally where the reference to the organisation scheme which defines it is provided elsewhere. The reference requires that the class (i.e. the type) or the organisation being reference be provided.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="base"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalOrganisationRefType extends LocalOrganisationRefBaseType {
    public LocalOrganisationRefType(IDType id,OrganisationTypeCodelistType clazz) {
        super(id,clazz); //,ItemSchemePackageTypeCodelistType.BASE);
    }
    public LocalOrganisationRefType(IDType id) {
        super(id,null);
    }
}
