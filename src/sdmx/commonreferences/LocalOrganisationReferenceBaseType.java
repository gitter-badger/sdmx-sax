/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalOrganisationReferenceBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalOrganisationReferenceBaseType is an abstract base type which provides a simple references to an organisation, regardless of type, where the identification of the organisation scheme which defines it is contained in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemReferenceType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalOrganisationRefBaseType" form="unqualified"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
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

public class LocalOrganisationReferenceBaseType extends LocalItemReferenceType {
    public LocalOrganisationReferenceBaseType(LocalOrganisationRefBaseType ref){
        super(ref);
    }
    
}
