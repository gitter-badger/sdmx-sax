/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationSchemeTypeCodelistType;

/**
 *	<xs:complexType name="OrganisationUnitSchemeRefType">
		<xs:annotation>
			<xs:documentation>OrganisationUnitSchemeRefType contains a set of reference fields for an organisation unit scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeRefBaseType">
				<xs:attribute name="class" type="OrganisationSchemeTypeCodelistType" use="optional" fixed="OrganisationUnitScheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class OrganisationUnitSchemeRefType extends OrganisationSchemeRefBaseType {
    public OrganisationUnitSchemeRefType(IDType id) {
        super(id,OrganisationSchemeTypeCodelistType.ORGANISATIONUNITSCHEME);
    }
    
}
