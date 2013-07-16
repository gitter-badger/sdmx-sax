/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="IdentifiableObjectTargetReferenceType">
		<xs:annotation>
			<xs:documentation>IdentifiableObjectTargetReferenceType is a type for referencing an identifiable object target object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="IdentifiableObjectTargetRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>				
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class IdentifiableObjectTargetReferenceType extends ComponentReferenceType {
    public IdentifiableObjectTargetReferenceType(IdentifiableObjectTargetRefType ref,anyURI uri){
        super(ref,uri);
    }
    public IdentifiableObjectTargetReferenceType(anyURI uri){
        super(uri);
    }
}
