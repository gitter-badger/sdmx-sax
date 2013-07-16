/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ProcessStepReferenceType">
		<xs:annotation>
			<xs:documentation>ProcessStepReferenceType is a type for referencing a process step object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ProcessStepRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ProcessStepReferenceType extends ChildObjectReferenceType {
    public ProcessStepReferenceType(ProcessStepRefType ref, anyURI uri){
        super(ref,uri);
    }
    public ProcessStepReferenceType(anyURI uri){
        super(uri);
    }
}
