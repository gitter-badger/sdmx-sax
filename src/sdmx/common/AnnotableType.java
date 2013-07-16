/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="AnnotableType" abstract="true">
		<xs:annotation>
				<xs:documentation>AnnotableType is an abstract base type used for all annotable artefacts. Any type that provides for annotations should extend this type.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element ref="Annotations" minOccurs="0"/>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */
public class AnnotableType {
    Annotations annotations = null;
    public AnnotableType(Annotations annots) {
        this.annotations=annots; 
    }
    public AnnotableType(){
    }
    public Annotations getAnnotations() { return annotations; }
    public void setAnnotations(Annotations annots) {
        this.annotations=annots;
    }
}
