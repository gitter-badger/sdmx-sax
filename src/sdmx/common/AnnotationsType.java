/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.LocalCodeReference;

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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public abstract class AnnotationsType {
    
    public AnnotationsType(List<AnnotationType> annots) {
        this.annots=annots;
    }
    public AnnotationsType(){
        this.annots = new ArrayList<AnnotationType>();
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
    public List<AnnotationType> getAnnotations() { return this.annots; }
    public void setAnnotations(List<AnnotationType> list) {this.annots=list;}
    
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.writeObject(annots);
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        annots = (List<AnnotationType>)ois.readObject();
    }
}

