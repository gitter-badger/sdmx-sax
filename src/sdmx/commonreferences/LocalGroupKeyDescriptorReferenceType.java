/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalGroupKeyDescriptorReferenceType">
		<xs:annotation>
			<xs:documentation>LocalGroupKeyDescriptorReferenceType is a type for referencing a group key descriptor locally, where the reference to the data structure definition which defines it is provided in another context (for example the data structure definition in which the reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalGroupKeyDescriptorRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalGroupKeyDescriptorReferenceType extends LocalComponentListReferenceType {
    public LocalGroupKeyDescriptorReferenceType(LocalGroupKeyDescriptorRefType ref){
        super(ref);
    }
}
