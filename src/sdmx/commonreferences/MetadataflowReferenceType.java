/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="MetadataflowReferenceType">
		<xs:annotation>
			<xs:documentation>MetadataflowReferenceType is a type for referencing a metadata flow object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="MetadataflowRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MetadataflowReferenceType extends StructureUsageReferenceBaseType {
      /**
     *
     */
    public MetadataflowReferenceType(MetadataflowRefType ref, anyURI urn){
        super(ref,urn);
    }
    public MetadataflowReferenceType(anyURI urn){
        super(urn);
    }
}
