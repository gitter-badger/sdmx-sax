/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ItemSchemeReferenceType">
		<xs:annotation>
			<xs:documentation>ItemSchemeReferenceType is a reference that is used for referencing any type of item scheme. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ItemSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ItemSchemeReferenceType extends ItemSchemeReferenceBaseType {
    public ItemSchemeReferenceType(ItemSchemeRefType ref, anyURI urn){
        super(ref,urn);
    }
    public ItemSchemeReferenceType(anyURI urn){
        super(urn);
    }
}
