/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="OrganisationUnitRefType">
		<xs:annotation>
			<xs:documentation>OrganisationUnitRefType contains a set of reference fields for referencing an organisation unit within an organisation unit scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="OrganisationUnit"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class OrganisationUnitRefType extends OrganisationRefBaseType {

    public OrganisationUnitRefType(OrganisationTypeCodelistType clazz){
        super(null,null,null,null,clazz);
    }
    
}
