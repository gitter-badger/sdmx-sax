/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;

/**
 *	<xs:complexType name="AnnotationsType">
		<xs:annotation>
			<xs:documentation>AnnotationsType provides for a list of annotations to be attached to data and structure messages.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Annotation" type="AnnotationType" maxOccurs="unbounded"/>
		</xs:sequence>
	</xs:complexType>
 * @author James
 */
public abstract class AnnotationsType {
    
    public AnnotationsType(List<AnnotationType> annots) {
        this.annots=annots;
    }
    
    List<AnnotationType> annots = new ArrayList<AnnotationType>();
    public AnnotationType getAnnotation(int i){
        return annots.get(i);
    }
    public void addAnnotation(AnnotationType at) {
        annots.add(at);
    }
    public AnnotationType removeAnnotation(AnnotationType at) {
        annots.remove(at);
        return at;
    }
    public int size() { return annots.size(); }
}

