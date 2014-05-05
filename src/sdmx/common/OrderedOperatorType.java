/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="OrderedOperatorType">
		<xs:annotation>
			<xs:documentation>OrderedOperatorType combines the SimpleOperatorType and the RangeOperatorType to provide a full range or operators for any ordered value.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="SimpleOperatorType RangeOperatorType"/>
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
public class OrderedOperatorType {

    public static final List<OrderedOperatorType> ENUM = new ArrayList<OrderedOperatorType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    // Simple
    public static final String NOT_EQUAL_TEXT = addString("notEqual");
    public static final String EQUAL_TEXT = addString("equal");
    // Range
    public static final String GREATER_THAN_OR_EQUAL_TEXT = addString("greaterThanOrEqual");
    public static final String LESS_THAN_OR_EQUAL_TEXT = addString("lessThanOrEqual");
    public static final String GREATER_THAN_TEXT =addString("greaterThan");
    public static final String LESS_THAN_TEXT =addString("lessThan");    
    public static final OrderedOperatorType NOT_EQUAL = add("notEqual");
    public static final OrderedOperatorType EQUAL = add("equal");
    // Range
    public static final OrderedOperatorType GREATER_THAN_OR_EQUAL = add("greaterThanOrEqual");
    public static final OrderedOperatorType LESS_THAN_OR_EQUAL = add("lessThanOrEqual");
    public static final OrderedOperatorType GREATER_THAN =add("greaterThan");
    public static final OrderedOperatorType LESS_THAN =add("lessThan");    
// Utility
    
    private static OrderedOperatorType add(String s) {
        OrderedOperatorType b = new OrderedOperatorType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static OrderedOperatorType fromString(String s) {
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
    public static OrderedOperatorType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in SimpleDataType enumeration!");
    }
// Instance
    private String target = null;

    public OrderedOperatorType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid OrderedOperatorType");
        }
        this.target = s;
    }

    public String toString() {
        return target;
    }

}
