/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="AnyCodelistReferenceType">
		<xs:annotation>
			<xs:documentation>AnyCodelistReferenceType is a specific type of a reference for referencing either a codelist or a hierarchical codelist usage. It consists of a URN and/or a complete set of reference fields; agency, id and version. If the complete set of reference fields is used, it is required that a class be provided so that the type of object referenced is clear.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="AnyCodelistRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AnyCodelistReferenceType extends MaintainableReferenceBaseType {
     public AnyCodelistReferenceType(AnyCodelistRefType ref,anyURI urn){
         super(ref,urn);
     }
     public AnyCodelistReferenceType(anyURI urn){
         super(urn);
     }
}
