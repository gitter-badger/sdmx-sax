/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalProcessStepReferenceType">
		<xs:annotation>
			<xs:documentation>LocalProcessStepReferenceType is a type for referencing a process step locally, where the reference to the process which defines it is provided in another context (for example the metadata structure definition in which the reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalProcessStepRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalProcessStepReferenceType extends LocalIdentifiableReferenceType {
    public LocalProcessStepReferenceType(LocalProcessStepRefType ref){
        super(ref);
    }
}
