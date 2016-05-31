/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="DataStructureComponentTypeCodelistType">
		<xs:annotation>
			<xs:documentation>DataStructureComponentTypeCodelistType provides an enumeration of all data structure component objects, except for the primary measure.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ComponentTypeCodelistType">
			<xs:enumeration value="Attribute"/>
			<xs:enumeration value="Dimension"/>
			<xs:enumeration value="MeasureDimension"/>
			<xs:enumeration value="PrimaryMeasure"/>
			<xs:enumeration value="ReportingYearStartDay"/>
			<xs:enumeration value="TimeDimension"/>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */

public class DataStructureComponentTypeCodelistType extends ComponentTypeCodelistType {

    public static final List<DataStructureComponentTypeCodelistType> ENUM = new ArrayList<DataStructureComponentTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_ATTRIBUTE = addString("Attribute");
    public static final String TARGET_DIMENSION = addString("Dimension");
    public static final String TARGET_MEASUREDIMENSION = addString("MeasureDimension");
    public static final String TARGET_PRIMARYMEASURE = addString("PrimaryMeasure");
    public static final String TARGET_REPORTINGYEARSTARTDAY = addString("ReportingYearStartDay");
    public static final String TARGET_TIMEDIMENSION = addString("TimeDimension");

    public static final DataStructureComponentTypeCodelistType ATTRIBUTE = add(TARGET_ATTRIBUTE);
    public static final DataStructureComponentTypeCodelistType DIMENSION = add(TARGET_DIMENSION);
    public static final DataStructureComponentTypeCodelistType MEASUREDIMENSION = add(TARGET_MEASUREDIMENSION);
    public static final DataStructureComponentTypeCodelistType PRIMARYMEASURE = add(TARGET_PRIMARYMEASURE);
    public static final DataStructureComponentTypeCodelistType REPORTINGYEARSTARTDAY = add(TARGET_REPORTINGYEARSTARTDAY);
    public static final DataStructureComponentTypeCodelistType TIMEDIMENSION = add(TARGET_TIMEDIMENSION);
// Utility
    private static DataStructureComponentTypeCodelistType add(String s){
        DataStructureComponentTypeCodelistType b = new DataStructureComponentTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static DataStructureComponentTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static DataStructureComponentTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in DataStructureComponentTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public DataStructureComponentTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid DataStructureComponentTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
    
}
