/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;

/**
 *	<xs:complexType name="AnnotableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>AnnotableWhereType is an abstract base type for querying an annotable artefact.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Annotation" type="AnnotationWhereType" minOccurs="0">
				<xs:annotation>
					<xs:documentation>Annotation is a parameter for matching the details of an annotatable object's annotations. It allows for querying based on the details of an annotation.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */

public class AnnotableWhereType {
    List<AnnotationWhereType> query = null;
    
}
