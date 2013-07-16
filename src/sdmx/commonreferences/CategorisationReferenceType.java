/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="CategorisationReferenceType">
		<xs:annotation>
			<xs:documentation>CategorisationReferenceType is a type for referencing a categorisation object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="CategorisationRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CategorisationReferenceType extends MaintainableReferenceBaseType {
    public CategorisationReferenceType(CategorisationRefType ref, anyURI urn){
        super(ref,urn);
    }
    public CategorisationReferenceType(anyURI urn){
        super(urn);
    }
}
