/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ContainerChildObjectReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>ContainerChildObjectReferenceType is an abstract base type used for referencing a particular object defined in a container object within a maintainable object. It consists of a URN and/or a complete set of reference fields; agency, maintainable id (maintainableParentID), maintainable version (maintainableParentVersion), container id (which is optional in order to allow for containers with fixed values to be omitted), container version (if applicable), the object id (which can be nested), and optionally the object version (if applicable).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ContainerChildObjectRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ContainerChildObjectReferenceType extends ReferenceType {
    public ContainerChildObjectReferenceType(ContainerChildObjectRefBaseType ref, anyURI urn){
        super(ref,urn);
    }
    public ContainerChildObjectReferenceType(anyURI urn){
        super(urn);
    }
}
