/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="HierarchicalCodeReferenceType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodeReferenceType is a type for referencing a hierarchical code object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="HierarchicalCodeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class HierarchicalCodeReferenceType extends ContainerChildObjectReferenceType {
    public HierarchicalCodeReferenceType(HierarchicalCodeRefType ref,anyURI urn){
        super(ref,urn);
    }
    
}
