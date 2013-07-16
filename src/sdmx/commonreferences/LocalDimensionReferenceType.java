/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalDimensionReferenceType">
		<xs:annotation>
			<xs:documentation>LocalDimensionReferenceType is a type for referencing any type of dimension locally, where the reference to the data structure definition which defines the dimension is provided in another context (for example the data structure definition in which the reference occurs).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalDimensionRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalDimensionReferenceType extends LocalComponentReferenceBaseType {
    public LocalDimensionReferenceType(LocalDimensionRefType ref){
        super(ref);
    }
}
