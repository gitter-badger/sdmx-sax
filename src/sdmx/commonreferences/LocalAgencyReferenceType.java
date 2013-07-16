/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalAgencyReferenceType">
		<xs:annotation>
			<xs:documentation>LocalAgencyReferenceType provides a simple reference to an agency, where the reference to the agency scheme which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalAgencyRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalAgencyReferenceType extends LocalOrganisationReferenceBaseType {
    public LocalAgencyReferenceType(LocalAgencyRefType clazz){
        super(clazz);
    }
}
