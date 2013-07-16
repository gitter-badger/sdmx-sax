/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataflowReferenceType">
		<xs:annotation>
			<xs:documentation>DataflowReferenceType is a type for referencing a dataflow object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="DataflowRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataflowReferenceType extends StructureUsageReferenceBaseType {
    public DataflowReferenceType(DataflowRefType ref, anyURI urn){
       super(ref,urn);
    }
    public DataflowReferenceType(anyURI urn){
       super(urn);
    }
}
