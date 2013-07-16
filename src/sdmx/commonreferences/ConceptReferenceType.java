/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ConceptReferenceType">
		<xs:annotation>
			<xs:documentation>ConceptReferenceType is a type for referencing a concept object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ConceptRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ConceptReferenceType extends ItemReferenceType {
    public ConceptReferenceType(ConceptRefType ref, anyURI urn) {
        super(ref,urn);
    }
    public ConceptReferenceType(anyURI urn) {
        super(urn);
    }

}
