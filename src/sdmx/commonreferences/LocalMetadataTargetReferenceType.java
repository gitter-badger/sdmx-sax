/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalMetadataTargetReferenceType">
		<xs:annotation>
			<xs:documentation>LocalMetadataTargetReferenceType is a type for referencing a metadata target locally, where the reference to the metadata structure definition which defines it is provided in another context (for example the metadata structure definition in which the reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalMetadataTargetRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalMetadataTargetReferenceType extends LocalComponentListReferenceType {
    public LocalMetadataTargetReferenceType(LocalMetadataTargetRefType ref){
       super(ref);  
    }
}
