/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="TextOperatorType">
		<xs:annotation>
			<xs:documentation></xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="SimpleOperatorType TextSearchOperatorType"/>
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
public class TextOperatorType {
    public static void main(String args[]) {}
    public static final List<TextOperatorType> ENUM = new ArrayList<TextOperatorType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
// Simple Operator
    public static final String NOT_EQUAL_TEXT = addString("notEqual");
    public static final String EQUAL_TEXT = addString("equal");
// Text Operator
    public static final String CONTAINS_TEXT = addString("contains");;
    public static final String STARTS_WITH_TEXT = addString("startsWith");;
    public static final String ENDS_WITH_TEXT = addString("endsWith");;
    public static final String DOES_NOT_CONTAIN_TEXT = addString("doesNotContain");;
    public static final String DOES_NOT_START_WITH_TEXT = addString("doesNotStartWith");;
    public static final String DOES_NOT_END_WITH_TEXT = addString("doesNotEndWith");;

// Simple
    public static final TextOperatorType NOT_EQUAL = add("notEqual");
    public static final TextOperatorType EQUAL = add("equal");
// Text
    public static final TextOperatorType CONTAINS = add("contains");
    public static final TextOperatorType STARTS_WITH = add("startsWith");
    public static final TextOperatorType ENDS_WITH = add("endsWith");
    public static final TextOperatorType DOES_NOT_CONTAIN = add("doesNotContain");
    public static final TextOperatorType DOES_NOT_START_WITH = add("doesNotStartWith");
    public static final TextOperatorType DOES_NOT_END_WITH = add("doesNotEndWith");
    
// Utility
    private static TextOperatorType add(String s) {
        TextOperatorType b = new TextOperatorType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static TextOperatorType fromString(String s) {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        return null;
    }

    /**
     *
     * @param s
     * @return
     * @throws TypeValueNotFoundException
     */
    public static TextOperatorType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in SimpleDataType enumeration!");
    }
// Instance
    private String target = null;

    public TextOperatorType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid TextOperatorType");
        }
        this.target = s;
    }

    public String toString() {
        return target;
    }

}
