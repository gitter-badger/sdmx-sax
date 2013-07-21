/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="MetadataStructureReferenceType">
		<xs:annotation>
			<xs:documentation>MetadataStructureReferenceType is a type for referencing a metadata structure definition object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="MetadataStructureRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataStructureReferenceType extends StructureReferenceBaseType {
    public MetadataStructureReferenceType(MetadataStructureRefType ref, anyURI uri){
       super(ref,uri);
    }
}