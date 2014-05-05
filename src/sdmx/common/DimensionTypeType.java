/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *<xs:simpleType name="DimensionTypeType">
		<xs:annotation>
			<xs:documentation>DimensionTypeType enumerates the sub-classes of a dimension.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="xs:string">
			<xs:enumeration value="Dimension">
				<xs:annotation>
					<xs:documentation>An ordinary dimension.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="MeasureDimension">
				<xs:annotation>
					<xs:documentation>A measure dimension.</xs:documentation>
				</xs:annotation>
			</xs:enumeration>
			<xs:enumeration value="TimeDimension">
				<xs:annotation>
					<xs:documentation>The time dimension.</xs:documentation>
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
public class DimensionTypeType {
    public static final List<DimensionTypeType> ENUM = new ArrayList<DimensionTypeType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

     public static final String DIMENSION_TEXT = addString("Dimension");
     public static final String MEASURE_TEXT = addString("MeasureDimension");
     public static final String TIME_TEXT = addString("TimeDimension");
     
     public static final DimensionTypeType DIMENSION = add(DIMENSION_TEXT);
     public static final DimensionTypeType MEASURE = add(MEASURE_TEXT);
     public static final DimensionTypeType TIME = add(TIME_TEXT);
    
// Utility
    private static DimensionTypeType add(String s) {
        DimensionTypeType b = new DimensionTypeType(s);
        ENUM.add(b);
        return b;
    }

    private static String addString(String s) {
        STRING_ENUM.add(s);
        return s;
    }

    public static DimensionTypeType fromString(String s) {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        return null;
    }

    public static DimensionTypeType fromStringWithException(String s) throws TypeValueNotFoundException {
        for (int i = 0; i < ENUM.size(); i++) {
            if (ENUM.get(i).target.equals(s)) {
                return ENUM.get(i);
            }
        }
        throw new TypeValueNotFoundException("Value:" + s + " not found in DimensionTypeType enumeration!");
    }
// Instance
    private String target = null;

    public DimensionTypeType(String s) {
        if (!STRING_ENUM.contains(s)) {
            throw new IllegalArgumentException(s + " is not a valid ObjectTypeCodelistType");
        }
        this.target = s;

    }

    public String toString() {
        return target;
    }
}
