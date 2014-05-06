/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="DimensionTypeCodelistType">
		<xs:annotation>
			<xs:documentation>DimensionTypeCodelistType provides an enumeration of all dimension objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ComponentTypeCodelistType">
			<xs:enumeration value="Dimension"/>
			<xs:enumeration value="MeasureDimension"/>
			<xs:enumeration value="TimeDimension"/>
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
public class DimensionTypeCodelistType extends ComponentTypeCodelistType {
    
    public static final List<DimensionTypeCodelistType> ENUM = new ArrayList<DimensionTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_DIMENSION = addString("Dimension");
    public static final String TARGET_MEASUREDIMENSION = addString("MeasureDimension");
    public static final String TARGET_TIMEDIMENSION = addString("TimeDimension");
    public static final DimensionTypeCodelistType DIMENSION = add(TARGET_DIMENSION);
    public static final DimensionTypeCodelistType MEASUREDIMENSION = add(TARGET_DIMENSION);
    public static final DimensionTypeCodelistType TIMEDIMENSION = add(TARGET_DIMENSION);

// Utility
    private static DimensionTypeCodelistType add(String s){
        DimensionTypeCodelistType b = new DimensionTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static DimensionTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static DimensionTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in DimensionTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public DimensionTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid DimensionTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
