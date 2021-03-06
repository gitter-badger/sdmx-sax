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
package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *		<xs:simpleType name="TwoLevelIDType">
		<xs:annotation>
			<xs:documentation>TwoLevelIDType defines an identifier with exactly two levels.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="NestedIDType">
			<xs:pattern value="[A-z0-9_@$\-]+\.[A-z0-9_@$\-]+"/>
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
public class TwoLevelID extends RegexXMLString {
    public static final String PATTERN = "[A-z0-9_@$\\-]+\\.[A-z0-9_@$\\-]+";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};

    public TwoLevelID(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
