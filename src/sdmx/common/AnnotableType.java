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
