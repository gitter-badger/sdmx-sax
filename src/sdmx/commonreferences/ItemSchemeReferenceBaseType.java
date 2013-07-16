/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ItemSchemeReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemSchemeReferenceBaseType is a specific type of MaintainableReference that is used for referencing item schemes. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ItemSchemeRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ItemSchemeReferenceBaseType extends MaintainableReferenceBaseType {
    public ItemSchemeReferenceBaseType(ItemSchemeRefBaseType ref, anyURI urn){
        super(ref,urn);
    }
    public ItemSchemeReferenceBaseType(anyURI urn){
        super(urn);
    }
}
