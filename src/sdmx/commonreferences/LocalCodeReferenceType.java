/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalCodeReferenceType">
		<xs:annotation>
			<xs:documentation>LocalCodeReferenceType provides a simple references to a code where the identification of the codelist which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalCodeRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalCodeReferenceType extends LocalItemReferenceType {
    public LocalCodeReferenceType(LocalCodeRefType ref) {
        super(ref);
    }
}
