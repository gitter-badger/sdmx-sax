/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="StructureUsageTypeCodelistType">
		<xs:annotation>
			<xs:documentation>StructureUsageTypeCodelistType provides an enumeration all structure usage objects</xs:documentation>
		</xs:annotation>
		<xs:restriction base="StructureOrUsageTypeCodelistType">
			<xs:enumeration value="Dataflow"/>
			<xs:enumeration value="Metadataflow"/>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */

public class StructureUsageTypeCodelistType extends StructureOrUsageCodelistType {

    public static final List<StructureUsageTypeCodelistType> ENUM = new ArrayList<StructureUsageTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_DATAFLOW = addString("Dataflow");
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final String TARGET_METADATAFLOW = addString("Metadataflow");
    public static final String TARGET_METADATASTRUCTURE = addString("MetadataStructure");
    
    public static final StructureUsageTypeCodelistType DATAFLOW = add(TARGET_DATAFLOW);
    public static final StructureUsageTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final StructureUsageTypeCodelistType METADATAFLOW = add(TARGET_METADATAFLOW);
    public static final StructureUsageTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    
// Utility
    private static StructureUsageTypeCodelistType add(String s){
        StructureUsageTypeCodelistType b = new StructureUsageTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static StructureUsageTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static StructureUsageTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in StructureUsageTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public StructureUsageTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid StructureUsageTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
