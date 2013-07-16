/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="LevelReferenceType">
		<xs:annotation>
			<xs:documentation>LevelReferenceType is a type for referencing a level object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="LevelRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LevelReferenceType extends ChildObjectReferenceType {
    public LevelReferenceType(LevelRefType ref,anyURI uri) {
        super(ref,uri);
    }
    public LevelReferenceType(anyURI uri) {
        super(uri);
    }
}
