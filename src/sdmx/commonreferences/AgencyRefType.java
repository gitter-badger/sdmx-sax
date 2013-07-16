/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="AgencyRefType">
		<xs:annotation>
			<xs:documentation>AgencyRefType contains a set of reference fields for referencing an agency within an agency scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="Agency"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class AgencyRefType extends OrganisationRefBaseType {
    public AgencyRefType(IDType id,OrganisationTypeCodelistType clazz){
        super(null,null,null,null,clazz);
    }
}
