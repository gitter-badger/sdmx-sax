/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalReportStructureReferenceType">
		<xs:annotation>
			<xs:documentation>LocalReportStructureReferenceType is a type for referencing a report structure locally, where the reference to the metadata structure definition which defines it is provided in another context (for example the metadata structure definition in which the reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalReportStructureRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalReportStructureReferenceType extends LocalComponentListReferenceType {

    public LocalReportStructureReferenceType(LocalReportStructureRefType ref){
        super(ref);
    }
    
}
