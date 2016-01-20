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

package sdmx.common;

/**
 *	<xs:simpleType name="AlphaType">
		<xs:annotation>
			<xs:documentation>AlphaType is a reusable simple type that allows for only mixed-case alphabetical characters. This is derived from the AlphaNumericType.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="AlphaNumericType">
			<xs:pattern value="[A-z]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class AlphaType extends AlphaNumericType {
    public static final String PATTERN = "[A-z]+";
    String s=null;
    public AlphaType(String s) {
        super(s);
        // TO DO: validation
    }
}
