/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalOrganisationUnitReferenceType">
		<xs:annotation>
			<xs:documentation>LocalOrganisationUnitReferenceType provides a simple reference to an organisation unit, where the reference to the organisation unit scheme which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalOrganisationUnitRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalOrganisationUnitReferenceType extends LocalOrganisationReferenceBaseType {
    public LocalOrganisationUnitReferenceType(LocalOrganisationUnitRefType ref) {
        super(ref);
    }
    
}
