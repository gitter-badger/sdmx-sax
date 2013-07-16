/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ConceptSchemeReferenceType">
		<xs:annotation>
				<xs:documentation>ConceptSchemeReferenceType is a type for referencing a concept scheme object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ConceptSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ConceptSchemeReferenceType extends ItemSchemeReferenceBaseType {
    public ConceptSchemeReferenceType(ConceptSchemeRefType ref, anyURI urn){
        super(ref,urn);
    }
    public ConceptSchemeReferenceType(anyURI urn){
        super(urn);
    }
}
