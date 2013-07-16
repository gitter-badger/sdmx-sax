/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureSetReferenceType">
		<xs:annotation>
			<xs:documentation>StructureSetReferenceType is a type for referencing a structure set object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="StructureSetRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>	

 * @author James
 */
public class StructureSetReferenceType extends MaintainableReferenceBaseType {
    public StructureSetReferenceType(StructureSetRefType ref, anyURI uri){
        super(ref,uri);
    }
    public StructureSetReferenceType(anyURI uri){
        super(uri);
    }
}
