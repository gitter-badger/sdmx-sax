/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ConceptSchemeMapReferenceType">
		<xs:annotation>
			<xs:documentation>ConceptSchemeMapReferenceType is a type for referencing a concept scheme map object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ConceptSchemeMapRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ConceptSchemeMapReferenceType extends ChildObjectReferenceType {
    public ConceptSchemeMapReferenceType(ConceptSchemeMapRefType ref, anyURI uri){
       super(ref,uri);
       }
    public ConceptSchemeMapReferenceType(anyURI uri){
       super(uri);
       }
}
