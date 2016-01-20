/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="TargetObjectTypeCodelistType">
		<xs:annotation>
			<xs:documentation>TargetObjectTypeCodelistType provides an enumeration of all target object objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ComponentTypeCodelistType">
			<xs:enumeration value="ConstraintTarget"/>
			<xs:enumeration value="DataSetTarget"/>
			<xs:enumeration value="IdentifiableObjectTarget"/>
			<xs:enumeration value="DimensionDescriptorValuesTarget"/>
			<xs:enumeration value="ReportPeriodTarget"/>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class TargetObjectTypeCodelistType extends ComponentTypeCodelistType {

    public static final List<TargetObjectTypeCodelistType> ENUM = new ArrayList<TargetObjectTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_CONSTRAINTARGET = addString("ConstraintTarget");
    public static final String TARGET_DATASETTARGET = addString("DataSetTarget");
    public static final String TARGET_IDENTIFIABLEOBJECTTARGET = addString("IdentifiableObjectTarget");
    public static final String TARGET_DIMENSIONDESCRIPTORVALUESTARGET = addString("DimensionDescriptorValuesTarget");
    public static final String TARGET_REPORTINGPERIODTARGET = addString("ReportPeriodTarget");

    public static final TargetObjectTypeCodelistType CONSTRAINTARGET = add(TARGET_CONSTRAINTARGET);
    public static final TargetObjectTypeCodelistType DATASETTARGET = add(TARGET_DATASETTARGET);
    public static final TargetObjectTypeCodelistType IDENTIFIABLEOBJECTTARGET = add(TARGET_IDENTIFIABLEOBJECTTARGET);
    public static final TargetObjectTypeCodelistType DIMENSIONDESCRIPTORVALUESTARGET = add(TARGET_DIMENSIONDESCRIPTORVALUESTARGET);
    public static final TargetObjectTypeCodelistType REPORTINGPERIODTARGET = add(TARGET_REPORTINGPERIODTARGET);
// Utility
    private static TargetObjectTypeCodelistType add(String s){
        TargetObjectTypeCodelistType b = new TargetObjectTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    /**
     *
     * @param s
     * @return
     */
    public static TargetObjectTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static TargetObjectTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in TargetObjectTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public TargetObjectTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid TargetObjectTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
