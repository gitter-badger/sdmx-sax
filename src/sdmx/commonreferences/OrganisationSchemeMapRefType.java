/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="OrganisationSchemeMapRefType">
		<xs:annotation>
			<xs:documentation>OrganisationSchemeMapRefType contains a set of reference fields for an organisation scheme map.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="OrganisationSchemeMap"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class OrganisationSchemeMapRefType extends ChildObjectRefBaseType {
    public OrganisationSchemeMapRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.ORGANISATIONSCHEMEMAP,PackageTypeCodelistType.MAPPING);
    }
}
