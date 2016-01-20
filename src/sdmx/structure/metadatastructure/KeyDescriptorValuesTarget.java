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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class KeyDescriptorValuesTarget extends KeyDescriptorValuesTargetType {
    
}
