/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ProvisionAgreementReferenceType">
		<xs:annotation>
			<xs:documentation>ProvisionAgreementReferenceType is a type for referencing a provision agreement. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ProvisionAgreementRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>		

 * @author James
 */
public class ProvisionAgreementReferenceType extends MaintainableReferenceBaseType {
    public ProvisionAgreementReferenceType(ProvisionAgreementRefType ref, anyURI uri){
        super(ref,uri);
    }
    public ProvisionAgreementReferenceType(anyURI uri){
        super(uri);
    }
}
