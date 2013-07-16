/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="MaintainableReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>MaintainableReferenceBaseType is an abstract base type for referencing a maintainable object. It consists of a URN and/or a complete set of reference fields; agency, id, and version.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="MaintainableRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MaintainableReferenceBaseType extends ReferenceType {
     public MaintainableReferenceBaseType(MaintainableRefBaseType ref,anyURI urn){
         super(ref,urn);
     }
     public MaintainableReferenceBaseType(anyURI urn){
         super(urn);
     }
}
