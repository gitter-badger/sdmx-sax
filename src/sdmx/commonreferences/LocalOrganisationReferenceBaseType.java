/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalOrganisationReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalOrganisationReferenceBaseType is an abstract base type which provides a simple references to an organisation, regardless of type, where the identification of the organisation scheme which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalOrganisationRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalOrganisationReferenceBaseType extends LocalItemReferenceType {
    public LocalOrganisationReferenceBaseType(LocalOrganisationRefBaseType ref){
        super(ref);
    }
    
}
