/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ComponentListReferenceType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentListReferenceType is an abstract base type used for referencing component lists within a structure. It consists of a URN and/or a complete set of reference fields (structure agency, structure id, structure version, and component list id).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ComponentListRefBaseType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ComponentListReferenceType extends ChildObjectReferenceType {
    public ComponentListReferenceType(ChildObjectRefBaseType ref, anyURI urn){
        super(ref,urn);
    }
    public ComponentListReferenceType(anyURI urn){
        super(urn);
    }

}
