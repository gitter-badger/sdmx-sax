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
 *	<xs:simpleType name="CodeTypeCodelistType">
 *		<xs:annotation>
 *			<xs:documentation>CodeTypeCodelistType provides an enumeration of all code objects.</xs:documentation>
 *		</xs:annotation>
 *		<xs:restriction base="ObjectTypeCodelistType">
 *			<xs:enumeration value="Code"/>
 *			<xs:enumeration value="HierarchicalCode"/>
 *		</xs:restriction>
 *	</xs:simpleType>
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
public class CodeTypeCodelistType extends ObjectTypeCodelistType {

    public static final List<CodeTypeCodelistType> ENUM = new ArrayList<CodeTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    public static final String TARGET_CODE = addString("Code");
    public static final String TARGET_HIERARCHICALCODE = addString("HierarchicalCode");

    public static final CodeTypeCodelistType CODE = add(TARGET_CODE);
    public static final CodeTypeCodelistType HIERARCHICALCODE = add(TARGET_HIERARCHICALCODE);

// Utility
    private static CodeTypeCodelistType add(String s){
        CodeTypeCodelistType b = new CodeTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static CodeTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static CodeTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in CodeTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public CodeTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid CodeTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
