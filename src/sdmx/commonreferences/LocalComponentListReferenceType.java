/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalComponentListReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalComponentListReferenceType is an abstract base type which provides a simple reference to a component list where the reference to the structure which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalComponentListRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentListReferenceType extends ReferenceType {
    public LocalComponentListReferenceType(LocalComponentListRefBaseType ref){
        super(ref,null);
    }
}
