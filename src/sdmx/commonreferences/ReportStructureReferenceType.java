/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ReportStructureReferenceType">
		<xs:annotation>
			<xs:documentation>ReportStructureReferenceType is a type for referencing a report structure object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ReportStructureRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ReportStructureReferenceType extends ComponentListReferenceType {
    public ReportStructureReferenceType(ReportStructureRefType ref, anyURI uri){
        super(ref,uri);
    }
    public ReportStructureReferenceType(anyURI uri){
        super(uri);
    }
}
