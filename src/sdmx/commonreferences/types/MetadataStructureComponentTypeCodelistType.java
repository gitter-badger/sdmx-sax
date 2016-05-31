/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="MetadataStructureComponentTypeCodelistType">
		<xs:annotation>
			<xs:documentation>MetadataStructureComponentTypeCodelistType provides an enumeration of all metadata structure component objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ComponentTypeCodelistType">
			<xs:enumeration value="ConstraintTarget"/>
			<xs:enumeration value="DataSetTarget"/>
			<xs:enumeration value="IdentifiableObjectTarget"/>
			<xs:enumeration value="DimensionDescriptorValuesTarget"/>
			<xs:enumeration value="MetadataAttribute"/>
			<xs:enumeration value="ReportPeriodTarget"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */

public class MetadataStructureComponentTypeCodelistType extends ComponentTypeCodelistType {

    public static final List<MetadataStructureComponentTypeCodelistType> ENUM = new ArrayList<MetadataStructureComponentTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_CONSTRAINTARGET = addString("ConstraintTarget");
    public static final String TARGET_DATASETTARGET = addString("DataSetTarget");
    public static final String TARGET_IDENTIFIABLEOBJECTTARGET = addString("IdentifiableObjectTarget");
    public static final String TARGET_DIMENSIONDESCRIPTORVALUESTARGET = addString("DimensionDescriptorValuesTarget");
    public static final String TARGET_METADATAATTRIBUTE = addString("MetadataAttribute");
    public static final String TARGET_REPORTINGPERIODTARGET = addString("ReportPeriodTarget");

    public static final MetadataStructureComponentTypeCodelistType CONSTRAINTARGET = add(TARGET_CONSTRAINTARGET);
    public static final MetadataStructureComponentTypeCodelistType DATASETTARGET = add(TARGET_DATASETTARGET);
    public static final MetadataStructureComponentTypeCodelistType IDENTIFIABLEOBJECTTARGET = add(TARGET_IDENTIFIABLEOBJECTTARGET);
    public static final MetadataStructureComponentTypeCodelistType DIMENSIONDESCRIPTORVALUESTARGET = add(TARGET_DIMENSIONDESCRIPTORVALUESTARGET);
    public static final MetadataStructureComponentTypeCodelistType METADATAATTRIBUTE = add(TARGET_METADATAATTRIBUTE);
    public static final MetadataStructureComponentTypeCodelistType REPORTINGPERIODTARGET = add(TARGET_REPORTINGPERIODTARGET);
// Utility
    private static MetadataStructureComponentTypeCodelistType add(String s){
        MetadataStructureComponentTypeCodelistType b = new MetadataStructureComponentTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static MetadataStructureComponentTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static MetadataStructureComponentTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in MetadataStructureComponentTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public MetadataStructureComponentTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid MetadataStructureComponentTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
