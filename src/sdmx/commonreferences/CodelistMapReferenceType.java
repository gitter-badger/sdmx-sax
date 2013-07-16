/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="CodelistMapReferenceType">
		<xs:annotation>
			<xs:documentation>CodelistMapReferenceType is a type for referencing a codelist map object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="CodelistMapRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>						
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CodelistMapReferenceType extends ChildObjectReferenceType {
    public CodelistMapReferenceType(CodelistMapRefType ref, anyURI uri){
        super(ref,uri);
    }
    public CodelistMapReferenceType(anyURI uri){
        super(uri);
    }
}
