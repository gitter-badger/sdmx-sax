/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataStructureEnumerationSchemeReferenceType">
		<xs:annotation>
			<xs:documentation>DataStructureEnumerationSchemeReferenceType is a type for referencing any type of item scheme that is allowable as the enumeration of the representation of a data structure definition component. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataStructureEnumerationSchemeRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataStructureEnumerationSchemeReferenceType extends ItemSchemeReferenceType {
    public DataStructureEnumerationSchemeReferenceType(DataStructureEnumerationSchemeRefType ref, anyURI uri){
        super(ref,uri);
    }
    public DataStructureEnumerationSchemeReferenceType(anyURI uri){
        super(uri);
    }
}
