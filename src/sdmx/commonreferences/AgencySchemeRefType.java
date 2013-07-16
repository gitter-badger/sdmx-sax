/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationSchemeTypeCodelistType;

/**
 *	<xs:complexType name="AgencySchemeRefType">
		<xs:annotation>
			<xs:documentation>AgencySchemeRefType contains a set of reference fields for an agency scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationSchemeRefBaseType">
				<xs:attribute name="class" type="OrganisationSchemeTypeCodelistType" use="optional" fixed="AgencyScheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class AgencySchemeRefType extends OrganisationSchemeRefBaseType {
    public AgencySchemeRefType(IDType id) {
        super(id,OrganisationSchemeTypeCodelistType.AGENCYSCHEME);
    }
}
