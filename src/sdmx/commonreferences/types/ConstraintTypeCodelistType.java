/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="ConstraintTypeCodelistType">
		<xs:annotation>
			<xs:documentation>ConstraintTypeCodelistType provides an enumeration of all constraint objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="MaintainableTypeCodelistType">
			<xs:enumeration value="AttachmentConstraint"/>
			<xs:enumeration value="ContentConstraint"/>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */

public class ConstraintTypeCodelistType extends MaintainableTypeCodelistType {
    public static final List<ConstraintTypeCodelistType> ENUM = new ArrayList<ConstraintTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    public static final String TARGET_ATTACHMENT = addString("AttachmentConstraint");
    public static final String TARGET_CONTENT = addString("ContentConstraint");
    public static final ConstraintTypeCodelistType ATTACHMENT = add(TARGET_ATTACHMENT);
    public static final ConstraintTypeCodelistType CONTENT = add(TARGET_CONTENT);
            
// Utility
    private static ConstraintTypeCodelistType add(String s){
        ConstraintTypeCodelistType b = new ConstraintTypeCodelistType(s);
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
    
    public static ConstraintTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).toString().equals(s))return ENUM.get(i);
        }
        return null;
    }
    
    public static ConstraintTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).toString().equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in ConstraintTypeCodelistType enumeration!");
    }
// Instance
    public ConstraintTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ObjectTypeCodelistType");
    }
   
}
