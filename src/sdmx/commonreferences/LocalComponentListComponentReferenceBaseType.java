/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *<xs:complexType name="LocalComponentListComponentReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalComponentListComponentReferenceBaseType is an abstract base type which provides a simple reference to any type of component in a specific component list where the reference to the structure which defines it are provided in another context, and the component list may or may not be defined in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalComponentListComponentRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentListComponentReferenceBaseType extends ReferenceType {
    public LocalComponentListComponentReferenceBaseType(LocalComponentListComponentRefBaseType ref){
        super(ref,null);
    }
}
