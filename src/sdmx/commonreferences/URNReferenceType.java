/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="URNReferenceType">
		<xs:annotation>
			<xs:documentation>URNReferenceType is a type referencing any object via its URN. The exact type of object is not specified, although it can be determined from the URN value.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class URNReferenceType extends ReferenceType {
    public URNReferenceType(anyURI urn){
        super(urn);
    }
}
