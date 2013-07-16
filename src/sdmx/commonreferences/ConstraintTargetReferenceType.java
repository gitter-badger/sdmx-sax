/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ConstraintTargetReferenceType">
		<xs:annotation>
			<xs:documentation>ConstraintTargetReferenceType is a type for referencing a constraint target object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ConstraintTargetRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>					
				</xs:choice>				
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ConstraintTargetReferenceType extends ComponentReferenceType {
    public ConstraintTargetReferenceType(ConstraintTargetRefType ref, anyURI uri){
        super(ref,uri);
    }
    public ConstraintTargetReferenceType(anyURI uri){
        super(uri);
    }
    
}
