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

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="AlphaNumericType">
		<xs:annotation>
			<xs:documentation>AlphaNumericType is a reusable simple type that allows for only mixed-case alphabetical and numeric characters.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:pattern value="[A-z0-9]+"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class AlphaNumericType extends RegexXMLString {
    public static final String PATTERN = "[A-z0-9]+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1};
    public AlphaNumericType(String s) {
        super(s);
    }
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }

}
