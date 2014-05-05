/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="LateBoundVersionType">
		<xs:annotation>
			<xs:documentation>LateBoundVersionType is a single value code list, used to include the '*' character - indicating that the latest version of an object is required.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="*">
				<xs:annotation>
					<xs:documentation>Indicates that the latest version of an object is requested.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
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
public class LateBoundVersionType extends RegexXMLString {
    public static final String LATE_VERSION_TEXT = "*";
    public static final LateBoundVersionType LATE_BOUND_VERSION = new LateBoundVersionType();

    private LateBoundVersionType() {
        super("*");
    }
}
