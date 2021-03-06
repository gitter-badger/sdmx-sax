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

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="TimeOperatorType">
		<xs:annotation>
			<xs:documentation>TimeOperatorType derives from the OrderedOperatorType to remove the notEqual operator.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="OrderedOperatorType">
			<xs:enumeration value="equal"/>
			<xs:enumeration value="greaterThanOrEqual"/>
			<xs:enumeration value="lessThanOrEqual"/>
			<xs:enumeration value="greaterThan"/>
			<xs:enumeration value="lessThan"/>
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
public class TimeOperatorType {
    public static void main(String args[]) {
    }
    public static final List<TimeOperatorType> ENUM = new ArrayList<TimeOperatorType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String EQUAL_TEXT =addString("equal");
    public static final String GREATER_THAN_OR_EQUAL_TEXT =addString("greaterThanOrEqual");
    public static final String LESS_THAN_OR_EQUAL_TEXT=addString("lessThanOrEqual");
    public static final String GREATER_THAN_TEXT =addString("greaterThan");
    public static final String LESS_THAN_TEXT=addString("lessThan");



    public static final TimeOperatorType EQUAL =add("equal");
    public static final TimeOperatorType GREATER_THAN_OR_EQUAL =add("greaterThanOrEqual");
    public static final TimeOperatorType LESS_THAN_OR_EQUAL=add("lessThanOrEqual");
    public static final TimeOperatorType GREATER_THAN =add("greaterThan");
    public static final TimeOperatorType LESS_THAN=add("lessThan");
// Utility
    private static TimeOperatorType add(String s) {
        TimeOperatorType b = new TimeOperatorType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static TimeOperatorType fromString(String s) {
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
    public static TimeOperatorType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in SimpleDataType enumeration!");
    }
// Instance
    private String target = null;

    public TimeOperatorType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid SimpleOperatorType");
        }
        this.target = s;
    }

    public String toString() {
        return target;
    }
}
