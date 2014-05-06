/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.xml.RegexXMLString;

/**
 *	<xs:simpleType name="VersionType">
		<xs:annotation>
			<xs:documentation>VersionType is used to communicate version information. The format is restricted to allow for simple incrementing and sorting of version number. The version consists of an unlimited set of numeric components, separated by the '.' character. When processing version, each numeric component (the number preceding and following any '.' character) should be parsed as an integer. Thus, a version of 1.3 and 1.03 would be equivalent, as both the '3' component and the '03' component would parse to an integer value of 3.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:pattern value="[0-9]+(\.[0-9]+)*"/>
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
public class VersionType extends RegexXMLString implements Comparable {
    public static final String PATTERN = "[0-9]+(\\.[0-9]+)*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
    public static final VersionType ONE = new VersionType("1.0");
    public static void main(String args[]) {}
    public VersionType(String s) {
        super(s);
    }
    @Override
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
   public boolean equals(VersionType id) {
       //System.out.println("left="+this.getString()+" right="+id.getString());
        return super.getString().equals(id.getString());
    }
    public boolean equals(String id) {
        return super.getString().equals(id);
    }
    public int compareTo(Object o) {
        if( !(o instanceof VersionType ))return -1;
        double a1 = Double.parseDouble(o.toString());
        double a2 = Double.parseDouble(toString());
        return a1>a2?1:a1<a2?-1:0;
    }
}
