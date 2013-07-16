/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ComponentReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentReferenceType is an abstract base type used for referencing components within a structure definition. It consists of a URN and/or a complete set of reference fields (structure agency, structure id, structure version, component list id, and component id).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ComponentRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ComponentReferenceType extends ContainerChildObjectReferenceType {
    public ComponentReferenceType(ComponentRefBaseType ref, anyURI urn){
        super(ref,urn);
    }
    public ComponentReferenceType(anyURI urn){
        super(urn);
    }
}
