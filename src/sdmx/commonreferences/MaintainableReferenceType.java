/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="MaintainableReferenceType">
		<xs:annotation>
			<xs:documentation>MaintainableReferenceType is a type for referencing any maintainable object. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="MaintainableRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MaintainableReferenceType extends MaintainableReferenceBaseType {
    public MaintainableReferenceType(MaintainableRefType ref, anyURI urn){
        super(ref,urn);
    }
    public MaintainableReferenceType(anyURI urn){
        super(urn);
    }
}
