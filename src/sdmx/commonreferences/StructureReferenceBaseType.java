/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureReferneceBaseType is a specific type of MaintainableReference that is used for referencing structure definitions. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="StructureRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureReferenceBaseType extends MaintainableReferenceBaseType {
    public StructureReferenceBaseType(StructureRefBaseType ref, anyURI urn) {
        super(ref,urn);
    }
    public StructureReferenceBaseType(anyURI urn) {
        super(urn);
    }

}
