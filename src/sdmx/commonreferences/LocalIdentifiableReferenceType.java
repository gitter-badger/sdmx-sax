/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalIdentifiableReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalIdentifiableReferenceType is an abstract base type for referencing an identifiable object locally, where the maintainable object in which it is defined is referenced in another context..</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalIdentifiableRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalIdentifiableReferenceType extends ReferenceType {
    public LocalIdentifiableReferenceType(LocalIdentifiableRefBaseType ref){
        super(ref,null);
    }
}
