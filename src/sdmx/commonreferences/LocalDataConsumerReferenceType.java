/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalDataConsumerReferenceType">
		<xs:annotation>
			<xs:documentation>LocalDataConsumerReferenceType provides a simple reference to a data consumer, where the reference to the data consumer scheme which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalDataConsumerRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalDataConsumerReferenceType extends LocalOrganisationReferenceBaseType {
    public LocalDataConsumerReferenceType(LocalDataConsumerRefType ref){
        super(ref);
    }
}
