/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:simpleType name="StructurePackageTypeCodelistType">
		<xs:annotation>
			<xs:documentation>StructurePackageTypeCodelistType provides an enumeration of all SDMX packages which contain structure and structure usages.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="PackageTypeCodelistType">
			<xs:enumeration value="datastructure"/>
			<xs:enumeration value="metadatastructure"/>
		</xs:restriction>
	</xs:simpleType>
 * @author James
 */
public class StructurePackageTypeCodelistType extends PackageTypeCodelistType{
    public static final List<StructurePackageTypeCodelistType> ENUM = new ArrayList<StructurePackageTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    public static final String TARGET_DATASTRUCTURE = addString("datastructure");
    public static final String TARGET_METADATASTRUCTURE = addString("metadatastructure");

    public static final StructurePackageTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final StructurePackageTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    
    
    // Utility
    private static StructurePackageTypeCodelistType add(String s){
        StructurePackageTypeCodelistType b = new StructurePackageTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }

    public static StructurePackageTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static StructurePackageTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in StructurePackageTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public StructurePackageTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid CodeTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
