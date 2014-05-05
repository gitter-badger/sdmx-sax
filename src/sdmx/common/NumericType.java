/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:simpleType name="NumericType">
		<xs:annotation>
			<xs:documentation>NumericType is a reusable simple type that allows for only numeric characters. This is not to be confused with an integer, as this may be used to numeric strings which have leading zeros. These leading zeros are not ignored. This is derived from the AlphaNumericType.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="AlphaNumericType">
			<xs:pattern value="[0-9]+"/>
		</xs:restriction>
	</xs:simpleType>
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
public class NumericType extends AlphaNumericType {
    public static final String PATTERN = "[0-9]+";
    public NumericType(String s) {
        super(s);
    }
}
