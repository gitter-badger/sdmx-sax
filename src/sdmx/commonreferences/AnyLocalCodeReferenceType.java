/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="AnyLocalCodeReferenceType">
		<xs:annotation>
			<xs:documentation>AnyLocalCodeReferenceType provides a simple references to any code or hierarchical code where the identification of the codelist or hierarchical codelist which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="AnyLocalCodeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AnyLocalCodeReferenceType extends ReferenceType {
    public AnyLocalCodeReferenceType(AnyLocalCodeRefType ref, anyURI urn){
        super(ref,urn);
    }
    public AnyLocalCodeReferenceType(anyURI urn){
        super(urn);
    }
}
