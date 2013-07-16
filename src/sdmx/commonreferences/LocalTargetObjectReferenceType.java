/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalTargetObjectReferenceType">
		<xs:annotation>
			<xs:documentation>LocalTargetObjectReferenceType is a type for referencing any type of target object within a metadata target locally, where the references to the metadata target and the  metadata structure definition which defines the target reference are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalTargetObjectRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalTargetObjectReferenceType extends LocalComponentReferenceBaseType {
    public LocalTargetObjectReferenceType(LocalTargetObjectRefType ref){
       super(ref);
    }
}
