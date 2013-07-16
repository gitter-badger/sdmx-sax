/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ReportingTaxonomyReferenceType">
		<xs:annotation>
			<xs:documentation>ReportingTaxonomyReferenceType is a type for referencing a reporting taxonomy object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ReportingTaxonomyRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ReportingTaxonomyReferenceType extends ItemSchemeReferenceBaseType {
    public ReportingTaxonomyReferenceType(ReportingTaxonomyRefType ref, anyURI uri){
        super(ref,uri);
    }
    public ReportingTaxonomyReferenceType(anyURI uri){
        super(uri);
    }
}
