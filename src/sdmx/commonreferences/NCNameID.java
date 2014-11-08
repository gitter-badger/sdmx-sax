/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.util.regex.Pattern;
import sdmx.SdmxIO;
import sdmx.common.ObservationDimensionType;

/**
 *	<xs:simpleType name="NCNameIDType">
		<xs:annotation>
			<xs:documentation>NCNameIDType restricts the IDType, so that the id may be used to generate valid XML components. IDs created from this type conform to the W3C XML Schema NCNAME type, and therefore can be used as element or attribute names.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="IDType">
			<xs:pattern value="[A-z][A-z0-9_\-]*"/>
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

public class NCNameID extends IDType {
    public static void main(String args[]) {
        NCNameID id = new NCNameID("1");
        Pattern[] patterns = id.getPatternArray();
        for (int i = 0; i < patterns.length; i++) {
            System.out.println("Check Pattern:"+"1"+":'"+patterns[i]+"'"+patterns[i].matcher("1").matches());
            if (!patterns[i].matcher("1").matches()) {
                if (SdmxIO.isStrictRegex()) {
                    throw new ExceptionInInitializerError("Input " + "1" + " does not match Pattern:" + patterns[i].pattern());
                }else {
                    System.out.println("Input "+"1"+" does not match Pattern:"+patterns[i].pattern()+" for class:"+id.getClass().getSimpleName());
                }
            }
        }
    }
    public static final String PATTERN = "[A-z][A-z0-9_\\-]*";
    public static final Pattern REGEX_PATTERN = Pattern.compile(PATTERN);
    public static final Pattern[] PATTERN_ARRAY = new Pattern[]{REGEX_PATTERN};
    public NCNameID(String s) {
        super(s);
    }
    @Override
    public Pattern[] getPatternArray() {
        return PATTERN_ARRAY;
    }
   public boolean equals(NCNameID id) {
        return super.getString().equals(id.getString());
    }
    public boolean equals(String id) {
        return super.getString().equals(id);
    }
}
