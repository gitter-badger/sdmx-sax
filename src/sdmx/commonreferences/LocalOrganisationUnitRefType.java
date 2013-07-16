/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalOrganisationUnitRefType">
		<xs:annotation>
			<xs:documentation>LocalOrganisationUnitRefType references an organisation unit locally where the reference to the organisation unit scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="OrganisationUnit"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalOrganisationUnitRefType extends LocalOrganisationRefBaseType {

    public LocalOrganisationUnitRefType(IDType id,OrganisationTypeCodelistType clazz) {
        super(id,clazz);
    }
    
}
