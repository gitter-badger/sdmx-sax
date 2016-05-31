/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
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
