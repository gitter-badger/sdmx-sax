/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalOrganisationReferenceType">
		<xs:annotation>
			<xs:documentation>LocalOrganisationReferenceType provides a simple reference to an organisation, regardless of type, where the identification of the organisation scheme which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalOrganisationRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalOrganisationReferenceType extends LocalOrganisationReferenceBaseType {
    public LocalOrganisationReferenceType(LocalOrganisationRefType ref) {
        super(ref);
    }
    
}
