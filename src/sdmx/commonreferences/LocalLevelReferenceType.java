/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalLevelReferenceType">
		<xs:annotation>
			<xs:documentation>LocalLevelReferenceType is a type for referencing a level object where the reference to the hierarchical codelist and the hierarchy in which it is defined is provided in another context (e.g. is inferred from the hierarchy in which the reference is defined).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalLevelRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalLevelReferenceType extends ReferenceType {
    public LocalLevelReferenceType(LocalLevelRefType ref){
       super(ref,null);
    }   
}
