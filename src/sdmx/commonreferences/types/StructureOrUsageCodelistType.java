/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:simpleType name="StructureOrUsageCodelistType">
		<xs:annotation>
			<xs:documentation>StructureOrUsageCodelistType provides an enumeration all structure and structure usage objects</xs:documentation>
		</xs:annotation>
		<xs:restriction base="MaintainableTypeCodelistType">
			<xs:enumeration value="Dataflow"/>
			<xs:enumeration value="DataStructure"/>
			<xs:enumeration value="Metadataflow"/>
			<xs:enumeration value="MetadataStructure"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class StructureOrUsageCodelistType extends MaintainableTypeCodelistType {

    public static final List<StructureOrUsageCodelistType> ENUM = new ArrayList<StructureOrUsageCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_DATAFLOW = addString("Dataflow");
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final String TARGET_METADATAFLOW = addString("Metadataflow");
    public static final String TARGET_METADATASTRUCTURE = addString("MetadataStructure");
    
    public static final StructureOrUsageCodelistType DATAFLOW = add(TARGET_DATAFLOW);
    public static final StructureOrUsageCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final StructureOrUsageCodelistType METADATAFLOW = add(TARGET_METADATAFLOW);
    public static final StructureOrUsageCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    
// Utility
    private static StructureOrUsageCodelistType add(String s){
        StructureOrUsageCodelistType b = new StructureOrUsageCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static StructureOrUsageCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static StructureOrUsageCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in StructureOrUsageCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public StructureOrUsageCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid StructureOrUsageCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
