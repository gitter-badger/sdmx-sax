/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalCodelistMapReferenceType">
		<xs:annotation>
			<xs:documentation>LocalCodelistMapReferenceType is a type for referencing a codelist map object where the reference to the structure set which defines it is provided in another context (e.g. the structure set in which this reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalCodelistMapRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalCodelistMapReferenceType extends ReferenceType {
    public LocalCodelistMapReferenceType(LocalCodelistMapRefType ref){
        super(ref,null);
    }
}
