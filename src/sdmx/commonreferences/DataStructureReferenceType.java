/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataStructureReferenceType">
		<xs:annotation>
			<xs:documentation>DataStructureReferenceType is a type for referencing a data structure definition object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataStructureRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class DataStructureReferenceType extends StructureReferenceBaseType {
    public DataStructureReferenceType(DataStructureRefType ref, anyURI urn){
        super(ref,urn);
    }
    public DataStructureReferenceType(anyURI urn){
        super(urn);
    }
    
}
