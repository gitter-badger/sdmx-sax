/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.regex.Pattern;

/**
 *	<xs:simpleType name="TimeRangeValidDateDurationType">
		<xs:annotation>
			<xs:documentation>TimeRangeValidDateDurationType is an abstract derivation of the RangeValidTimeType which validates that duration provided is generally valid, up to the time component.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="RangeValidTimeZoneType">
			<xs:pattern value=".+/P(\d+Y)?(\d+M)?(\d+D)?(T.+)?"/>
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
public class TimeRangeValidDateDurationType extends RangeValidTimeZoneType {
    public static final String PATTERN = ".+/P(\\d+Y)?(\\d+M)?(\\d+D)?(T.+)?";
    public static final Pattern REGEX_PATTERN1 = Pattern.compile(PATTERN1);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN1};

    public TimeRangeValidDateDurationType(String s) {
        super(s);
    }

    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
}
