/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:element name="KeyDescriptorValuesTarget" type="KeyDescriptorValuesTargetType" substitutionGroup="Component">
		<xs:annotation>
			<xs:documentation>KeyDescriptorValuesTarget is target object which references a data key for the purpose of attach reference metadata to portions of data. A data key is a set of dimension references and values for those dimension. This component on its own is not of much use, as the data key only has local references to the dimensions. Therefore it is typical that this is used in combination with some sort of reference to the data (either a data set reference or a reference to the underlying structure, structure usage, or provision agreement of the data.</xs:documentation>
		</xs:annotation>
	</xs:element>
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
public class KeyDescriptorValuesTarget extends KeyDescriptorValuesTargetType {
    
}
