/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalPrimaryMeasureReferenceType">
		<xs:annotation>
			<xs:documentation>LocalPrimaryMeasureReferenceType is a type for referencing a primary measure locally, where the reference to the data structure definition which defines the primary measure is provided in another context (for example the data structure definition in which the reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalPrimaryMeasureRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalPrimaryMeasureReferenceType extends LocalComponentReferenceBaseType {
    public LocalPrimaryMeasureReferenceType(LocalPrimaryMeasureRefType ref){
        super(ref);
    }
}
