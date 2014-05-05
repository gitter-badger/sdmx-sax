/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="BaseTimeRangeType">
		<xs:annotation>
			<xs:documentation>BaseTimeRangeType is a simple type which frames the general pattern for a time range in SDMX. A time range pattern is generally described as [xs:date or xs:dateTime]\[xs:duration], where the referenced types are defined by XML Schema. This type is meant to be derived from for further validation.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:pattern value="\d{4}\-\d{2}\-\d{2}(T\d{2}:\d{2}:\d{2}(\.\d+)?)?(Z|((\+|\-)\d{2}:\d{2}))?/P.+"/>
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
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class BaseTimeRangeType extends RegexXMLString {
    public static final String PATTERN = "\\d{4}\\-\\d{2}\\-\\d{2}(T\\d{2}:\\d{2}:\\d{2}(\\.\\d+)?)?(Z|((\\+|\\-)\\d{2}:\\d{2}))?/P.+";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1};
    public BaseTimeRangeType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
