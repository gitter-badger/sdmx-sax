/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

/**
 *	<xs:complexType name="LocalDataProviderReferenceType">
		<xs:annotation>
			<xs:documentation>LocalDataProviderReferenceType provides a simple reference to a data provider, where the reference to the data provider scheme which defines it is provided in another context.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationReferenceBaseType">
				<xs:sequence>
					<xs:element name="Ref" type="LocalDataProviderRefType" form="unqualified"/>
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
public class LocalDataProviderReferenceType extends LocalOrganisationReferenceBaseType {
    public LocalDataProviderReferenceType(LocalDataProviderRefType ref){
        super(ref);
    }
    
}
