/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
package sdmx.commonreferences;

import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="TransitionReferenceType">
		<xs:annotation>
			<xs:documentation>TransiationReferenceType is a type for referencing a process step object. It consists of a URN and/or a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectReferenceType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="TransitionRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>		
	</xs:complexType>

 * @author James
 */

public class TransitionReference extends ContainerChildObjectReference {
    public TransitionReference(TransitionRef ref, anyURI uri){
        super(ref,uri);
    }
    public TransitionReference(anyURI uri){
        super(uri);
    }
}
