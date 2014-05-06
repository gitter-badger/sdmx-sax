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
