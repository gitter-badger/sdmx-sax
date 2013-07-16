/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.DistinctKeyValueTypeChoice;
import sdmx.common.choice.MetadataKeyValueTypeChoice;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ObjectReferenceType">
		<xs:annotation>
			<xs:documentation>ObjectReferenceType is a generic reference which allows for any object to be referenced. The type of object actually referenced can be determined from the URN or from the class attribute of the full set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="ObjectRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ObjectReferenceType extends ReferenceType implements ComponentValueSetTypeChoice,DistinctKeyValueTypeChoice,MetadataKeyValueTypeChoice,MetadataTargetRegionKeyTypeChoice {
    public ObjectReferenceType(RefBaseType ref, anyURI urn) {
        super(ref,urn);
    }
   public ObjectReferenceType(anyURI urn) {
       super(urn);
    }
   public void test() {
       System.out.println("TEst!");
   }
}
