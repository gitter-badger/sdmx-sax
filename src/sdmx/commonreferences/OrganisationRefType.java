/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="OrganisationRefType">
		<xs:annotation>
			<xs:documentation>OrganisationRefType provides a reference to any organisation via a complete set of reference fields. It is required that the class (i.e. the type) of organisation being referenced be specified.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="OrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class OrganisationRefType extends OrganisationRefBaseType {
    public OrganisationRefType(OrganisationTypeCodelistType clazz) {
        super(null,null,null,null,clazz);
    }
}
