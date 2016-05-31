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
 *	<xs:complexType name="LocalDataConsumerReferenceType">
		<xs:annotation>
			<xs:documentation>LocalDataConsumerReferenceType provides a simple reference to a data consumer, where the reference to the data consumer scheme which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalDataConsumerRefType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */

public class LocalDataConsumerReference extends LocalOrganisationReferenceBase {
    public LocalDataConsumerReference(LocalDataConsumerRef ref){
        super(ref);
    }
}
