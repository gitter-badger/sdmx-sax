/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureUsageReferenceType">
		<xs:annotation>
			<xs:documentation>StructureUsageReferenceType is a specific type of MaintainableReference that is used for referencing any structure usages. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="StructureUsageRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureUsageReferenceType extends StructureUsageReferenceBaseType {
    public StructureUsageReferenceType(StructureUsageRefType ref, anyURI urn) {
        super(ref,urn);
    }
    public StructureUsageReferenceType(anyURI urn) {
        super(urn);
    }
}
