/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalItemReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalItemReferenceType is an abstract base type which provides a simple reference to an item where the reference to the item scheme which defines it are provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalItemRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalItemReferenceType extends ReferenceType {
    public LocalItemReferenceType(LocalItemRefBaseType ref) {
        super(ref,null);
    }

}
