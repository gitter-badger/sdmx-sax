/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalAgencyRefType">
		<xs:annotation>
			<xs:documentation>LocalAgencyRefType references an agency locally where the reference to the agency scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="Agency"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>	

 * @author James
 */
public class LocalAgencyRefType extends LocalOrganisationRefBaseType {
    public LocalAgencyRefType(IDType id,OrganisationTypeCodelistType clazz) {
        super(id,clazz);
    }
    
}
