/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ReportingCategoryReferenceType">
		<xs:annotation>
			<xs:documentation>ReportingCategoryReferenceType is a type for referencing a reporting category object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ReportCategoryRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ReportingCategoryReferenceType extends ItemReferenceType {
    public ReportingCategoryReferenceType(ReportCategoryRefType ref, anyURI uri){
        super(ref,uri);
    }
    public ReportingCategoryReferenceType(anyURI uri){
        super(uri);
    }
    
}
