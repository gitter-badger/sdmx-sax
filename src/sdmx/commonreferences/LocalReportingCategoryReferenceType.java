/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalReportingCategoryReferenceType">
		<xs:annotation>
			<xs:documentation>LocalReportingCategoryReferenceType provides a simple references to a reporting category where the identification of the reporting taxonomy which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalReportingCategoryRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalReportingCategoryReferenceType extends LocalItemReferenceType {
     public LocalReportingCategoryReferenceType(LocalReportingCategoryRefType ref) {
         super(ref);
     }
}
