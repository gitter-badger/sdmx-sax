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
 *	<xs:simpleType name="SimpleOperatorType">
		<xs:annotation>
			<xs:documentation>SimpleOperatorType provides an enumeration of simple operators to be applied to any value.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="notEqual">
				<xs:annotation>
					<xs:documentation>(!=) - value must not be equal to the value supplied.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="equal">
				<xs:annotation>
					<xs:documentation>(=) - value must be exactly equal to the value supplied.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
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
public class SimpleOperatorType {

    public static final List<SimpleOperatorType> ENUM = new ArrayList<SimpleOperatorType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    
    public static final String NOT_EQUAL_TEXT = addString("notEqual");
    public static final String EQUAL_TEXT = addString("equal");
    public static final SimpleOperatorType NOT_EQUAL = add("notEqual");
    public static final SimpleOperatorType EQUAL = add("equal");
// Utility
    private static SimpleOperatorType add(String s) {
        SimpleOperatorType b = new SimpleOperatorType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static SimpleOperatorType fromString(String s) {
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
    public static SimpleOperatorType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in SimpleDataType enumeration!");
    }
// Instance
    private String target = null;

    public SimpleOperatorType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid SimpleOperatorType");
        }
        this.target = s;
    }

    public String toString() {
        return target;
    }
}
