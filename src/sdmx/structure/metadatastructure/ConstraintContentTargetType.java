/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="ConstraintContentTargetType">
		<xs:annotation>
			<xs:documentation>ConstraintTargetType defines the structure of a constraint target object. The constraint target object has a fixed representation and identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="ConstraintRepresentationType"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="optional" fixed="CONSTRAINT_CONTENT_TARGET"/>
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
public class ConstraintContentTargetType extends TargetObject {
    ConstraintRepresentationType localRepresentation = null;
}
