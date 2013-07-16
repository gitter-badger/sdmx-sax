/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalMetadataStructureComponentReferenceType">
		<xs:annotation>
			<xs:documentation>LocalMetadataStructureComponentReferenceType is a type for referencing any type of metadata structure component locally, where the reference for the metadata structure definition which defines the components is available in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalMetadataStructureComponentRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalMetadataStructureComponentReferenceType extends LocalComponentListComponentReferenceBaseType {
    public LocalMetadataStructureComponentReferenceType(LocalMetadataStructureComponentRefType ref){
        super(ref);
    }
}
