/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="StructureTypeCodelistType">
		<xs:annotation>
			<xs:documentation>StructureTypeCodelistType provides an enumeration all structure objects</xs:documentation>
		</xs:annotation>
		<xs:restriction base="StructureOrUsageTypeCodelistType">
			<xs:enumeration value="DataStructure"/>
			<xs:enumeration value="MetadataStructure"/>
		</xs:restriction>
	</xs:simpleType>

 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class StructureTypeCodelistType extends StructureOrUsageCodelistType {

    public static final List<StructureTypeCodelistType> ENUM = new ArrayList<StructureTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final String TARGET_METADATASTRUCTURE = addString("MetadataStructure");
    
    public static final StructureTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final StructureTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    
// Utility
    private static StructureTypeCodelistType add(String s){
        StructureTypeCodelistType b = new StructureTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static StructureTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static StructureTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in StructureTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public StructureTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid StructureTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
