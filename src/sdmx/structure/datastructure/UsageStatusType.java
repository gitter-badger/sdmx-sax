/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.exception.TypeValueNotFoundException;

/**
 *
 * @author James
 */

public class UsageStatusType {

    public static final List<UsageStatusType> ENUM = new ArrayList<UsageStatusType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String CONDITIONAL_TEXT = addString("Conditional");
    public static final String MANDATORY_TEXT = addString("Mandatory");

    public static final UsageStatusType CONDITIONAL = add(CONDITIONAL_TEXT);
    public static final UsageStatusType MANDATORY = add(MANDATORY_TEXT);

// Utility
    private static UsageStatusType add(String s){
        UsageStatusType b = new UsageStatusType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static UsageStatusType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static UsageStatusType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in enumeration! - ObjectypeCodelistType");
    }
// Instance
    private String target = null;
    public UsageStatusType(String s) {
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ObjectTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
    
}
