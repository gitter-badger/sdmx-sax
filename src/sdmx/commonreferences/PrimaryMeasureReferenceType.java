/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="PrimaryMeasureReferenceType">
		<xs:annotation>
			<xs:documentation>PrimaryMeasureReferenceType is a type for referencing a primary measure object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="PrimaryMeasureRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class PrimaryMeasureReferenceType extends ComponentReferenceType {
    public PrimaryMeasureReferenceType(PrimaryMeasureRefType ref, anyURI uri){
        super(ref,uri);
    }
    public PrimaryMeasureReferenceType(anyURI uri){
        super(uri);
    }
}