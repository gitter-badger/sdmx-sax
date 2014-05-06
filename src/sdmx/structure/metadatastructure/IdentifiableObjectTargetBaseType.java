/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="IdentifiableObjectTargetBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>IdentifiableObjectTargetBaseType is an abstract base type which forms the basis for the IdentifiableObjectTargetType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="IdentifiableObjectRepresentationType"/>				
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="required"/>
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
public class IdentifiableObjectTargetBaseType extends TargetObject {
    
}
