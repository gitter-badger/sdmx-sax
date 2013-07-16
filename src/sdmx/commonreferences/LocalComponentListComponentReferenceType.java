/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalComponentListComponentReferenceType">
		<xs:annotation>
			<xs:documentation>LocalComponentListComponentReferenceType provides a simple reference to any type of component in a specific component list where the reference to the structure which defines it are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalComponentListComponentRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentListComponentReferenceType extends LocalComponentListComponentReferenceBaseType {
    public LocalComponentListComponentReferenceType(LocalComponentListComponentRefType ref){
        super(ref);
    }
}
