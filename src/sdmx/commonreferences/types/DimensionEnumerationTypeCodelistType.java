/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="DimensionEumerationSchemeTypeCodelistType">
		<xs:annotation>
			<xs:documentation>DimensionEumerationSchemeTypeCodelistType provides an enumeration of all item schemes which are allowable as the representation of a data structure definition component.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ItemSchemeTypeCodelistType">
			<xs:enumeration value="Codelist"/>
			<xs:enumeration value="ConceptScheme"/>
		</xs:restriction>
	</xs:simpleType>


 * @author James
 */

public class DimensionEnumerationTypeCodelistType extends ItemSchemeTypeCodelistType {

    public static final List<DimensionEnumerationTypeCodelistType> ENUM = new ArrayList<DimensionEnumerationTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_CODELIST = addString("ReportingTaxonomy");
    public static final String TARGET_CONCEPTSCHEME = addString("ConceptScheme");

    public static final DimensionEnumerationTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final DimensionEnumerationTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);

// Utility
    private static DimensionEnumerationTypeCodelistType add(String s){
        DimensionEnumerationTypeCodelistType b = new DimensionEnumerationTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static DimensionEnumerationTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static DimensionEnumerationTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in DimensionEnumerationTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public DimensionEnumerationTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ObjectTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
