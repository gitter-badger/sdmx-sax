/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="HierarchyReferenceType">
		<xs:annotation>
			<xs:documentation>HierarchyReferenceType is a type for referencing a hierarchy within a hierarchical codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="HierarchyRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class HierarchyReference extends ChildObjectReference {
    public HierarchyReference(HierarchRef ref,anyURI uri){
        super(ref,uri);
    }
    public HierarchyReference(anyURI uri){
        super(uri);
    }
}
