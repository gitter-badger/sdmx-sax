/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalDataProviderReferenceType">
		<xs:annotation>
			<xs:documentation>LocalDataProviderReferenceType provides a simple reference to a data provider, where the reference to the data provider scheme which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalDataProviderRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalDataProviderReferenceType extends LocalOrganisationReferenceBaseType {
    public LocalDataProviderReferenceType(LocalDataProviderRefType ref){
        super(ref);
    }
    
}
