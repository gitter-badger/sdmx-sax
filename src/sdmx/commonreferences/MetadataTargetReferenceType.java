/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="MetadataTargetReferenceType">
		<xs:annotation>
			<xs:documentation>MetadataTargetReferenceType is a type for referencing a metadata target object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="MetadataTargetRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataTargetReferenceType extends ComponentListReferenceType {
    public MetadataTargetReferenceType(MetadataTargetRefType ref, anyURI uri){
        super(ref,uri);
    }
    public MetadataTargetReferenceType(anyURI uri){
        super(uri);
    }
}
