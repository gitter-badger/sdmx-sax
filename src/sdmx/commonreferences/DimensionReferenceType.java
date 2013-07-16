/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DimensionReferenceType">
		<xs:annotation>
			<xs:documentation>DimensionReferenceType is a type for referencing a dimension object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DimensionRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DimensionReferenceType extends ComponentReferenceType {
    public DimensionReferenceType(DimensionRefType ref, anyURI urn){
        super(ref,urn);
    }
    public DimensionReferenceType(anyURI urn){
        super(urn);
    }
}
