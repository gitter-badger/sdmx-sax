/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalDataStructureComponentReferenceType">
		<xs:annotation>
			<xs:documentation>LocalDataStructureComponentReferenceType is a type for referencing any type of data structure component locally, where the reference for the data structure definition which defines the components is available in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalDataStructureComponentRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalDataStructureComponentReferenceType extends LocalComponentListComponentReferenceBaseType {
    public LocalDataStructureComponentReferenceType(LocalDataStructureComponentRefType ref){
        super(ref);
    }
}
