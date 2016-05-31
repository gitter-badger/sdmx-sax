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

public class LocalLevelReference extends ReferenceType {
    public LocalLevelReference(LocalLevelRef ref){
       super(ref,null);
    }   
}
