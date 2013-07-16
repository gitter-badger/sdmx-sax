/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureUsageReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureUsageReferenceBaseType is a specific type of MaintainableReference that is used for referencing structure usages. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="StructureUsageRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureUsageReferenceBaseType extends MaintainableReferenceBaseType {
    public StructureUsageReferenceBaseType(StructureUsageRefBaseType ref, anyURI urn) {
        super(ref,urn);
    }
    public StructureUsageReferenceBaseType(anyURI urn) {
        super(urn);
    }
}
