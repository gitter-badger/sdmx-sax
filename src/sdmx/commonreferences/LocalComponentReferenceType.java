/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalComponentReferenceType">
		<xs:annotation>
			<xs:documentation>LocalComponentReferenceType provides a simple reference to any type of component in a component list where the references to the component list and the structure which defines them are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalComponentRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentReferenceType extends LocalComponentListComponentReferenceBaseType {
    public LocalComponentReferenceType(LocalComponentRefType ref){
        super(ref);
    }
}
