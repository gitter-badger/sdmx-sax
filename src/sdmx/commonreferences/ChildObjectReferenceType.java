/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ChildObjectReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>ChildObjectReferenceType is an abstract base type used for referencing a particular object defined directly within a maintainable object. It consists of a URN and/or a complete set of reference fields; agency, maintainable id (maintainableParentID), maintainable version (maintainableParentVersion), the object id (which can be nested), and optionally the object version (if applicable).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ChildObjectRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ChildObjectReferenceType extends ReferenceType {
    public ChildObjectReferenceType(ChildObjectRefBaseType ref, anyURI urn){
        super(ref,urn);
    }
    public ChildObjectReferenceType(anyURI urn){
        super(urn);
    }
}
