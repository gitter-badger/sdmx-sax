/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalComponentReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalComponentReferenceBaseType is an abstract base type which provides a simple reference to a component where the references to the component list which contains it and the structure which defines it are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalComponentRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentReferenceBaseType extends LocalComponentListComponentReferenceBaseType {
    public LocalComponentReferenceBaseType(LocalComponentRefBaseType ref){
        super(ref);
    }
}
