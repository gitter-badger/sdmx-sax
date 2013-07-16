/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;



import sdmx.commonreferences.types.OrganisationTypeCodelistType;
/**
 *	<xs:complexType name="OrganisationRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>OrganisationRefBaseType is an abstract base type which references an organisation from within a organisation scheme. Reference fields are required for both the scheme and the organisation.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the organisation scheme in which the organisation being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the organisation scheme in which the organisation being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="base"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class OrganisationRefBaseType extends ItemRefBaseType {

    public OrganisationRefBaseType(NestedNCNameIDType agency,IDType parentId,VersionType pVers,IDType id,OrganisationTypeCodelistType clazz) {
        super(agency, parentId, pVers, id, clazz, ItemSchemePackageTypeCodelistType.BASE);
    }
}
