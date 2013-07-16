/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureReferenceType">
		<xs:annotation>
			<xs:documentation>StructureReferenceType is a specific type of MaintainableReference that is used for referencing any structure. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="StructureRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureReferenceType extends StructureReferenceBaseType {
    public StructureReferenceType(StructureRefType ref, anyURI urn) {
        super(ref,urn);
    }
    public StructureReferenceType(anyURI urn) {
        super(urn);
    }
}
