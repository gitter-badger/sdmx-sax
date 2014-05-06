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
 *	<xs:simpleType name="ItemSchemePackageTypeCodelistType">
		<xs:annotation>
			<xs:documentation>ItemSchemePackageTypeCodelistType provides an enumeration of all SDMX packages which contain item schemes.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="PackageTypeCodelistType">
			<xs:enumeration value="base"/>
			<xs:enumeration value="codelist"/>
			<xs:enumeration value="categoryscheme"/>
			<xs:enumeration value="conceptscheme"/>
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
public class ItemSchemePackageTypeCodelistType extends PackageTypeCodelistType {
    public static final List<ItemSchemePackageTypeCodelistType> ENUM = new ArrayList<ItemSchemePackageTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    public static final String TARGET_BASE = addString("base");
    public static final String TARGET_CODELIST = addString("codelist");
    public static final String TARGET_CATEGORYCHEME = addString("categoryscheme");
    public static final String TARGET_CONCEPTSCHEME = addString("conceptscheme");
    
    public static final ItemSchemePackageTypeCodelistType BASE = add(TARGET_BASE);
    public static final ItemSchemePackageTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final ItemSchemePackageTypeCodelistType CATEGORYSCHEME = add(TARGET_CATEGORYSCHEME);
    public static final ItemSchemePackageTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);
    
    // This isn't listed as a valid value for this type, however
    // the 'Dataflow' type needs this to be here.
    public static final String TARGET_DATASTRUCTURE = addString("datastructure");
    public static final ItemSchemePackageTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);

// Utility
    private static ItemSchemePackageTypeCodelistType add(String s){
        ItemSchemePackageTypeCodelistType b = new ItemSchemePackageTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static ItemSchemePackageTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static ItemSchemePackageTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in ItemSchemePackageTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public ItemSchemePackageTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ObjectTypeCodelistType");
        this.target=s;
        
    }
    public String toString() { return target; }
}
