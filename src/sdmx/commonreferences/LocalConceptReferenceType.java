/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalConceptReferenceType">
		<xs:annotation>
			<xs:documentation>LocalConceptReferenceType provides a simple references to a concept where the identification of the concept scheme which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalConceptRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalConceptReferenceType extends LocalItemReferenceType {
    public LocalConceptReferenceType(LocalConceptRefType ref){
        super(ref);
    }
    
}
