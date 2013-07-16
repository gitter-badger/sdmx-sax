/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ItemReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemReferenceType is an abstract base type used for referencing a particular item within an item scheme. Note that this reference also has the ability to reference items contained within other items inside of the item scheme. It consists of a URN and/or a complete set of reference fields; agency, scheme id (maintainableParentID), scheme version (maintainableParentVersion), and item id (which can be nested).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ItemRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ItemReferenceType extends ChildObjectReferenceType {
    public ItemReferenceType(ItemRefBaseType ref, anyURI urn){
        super(ref,urn);
    }
    public ItemReferenceType(anyURI urn){
        super(urn);
    }
}
