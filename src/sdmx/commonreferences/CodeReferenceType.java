/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="CodeReferenceType">
		<xs:annotation>
			<xs:documentation>CodeReferenceType is a type for referencing a code object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="CodeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CodeReferenceType extends ItemReferenceType {
    public CodeReferenceType(CodeRefType ref, anyURI urn){
        super(ref,urn);
    }
    public CodeReferenceType(anyURI urn){
        super(urn);
    }

}
