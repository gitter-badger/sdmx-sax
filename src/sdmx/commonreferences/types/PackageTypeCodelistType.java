/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="PackageTypeCodelistType">
*		<xs:annotation>
*			<xs:documentation>PackageTypeCodelistType provides an enumeration of all SDMX package names.</xs:documentation>
*		</xs:annotation>
*		<xs:restriction base="xs:string">
*			<xs:enumeration value="base"/>
*			<xs:enumeration value="datastructure"/>
*			<xs:enumeration value="metadatastructure"/>
*			<xs:enumeration value="process"/>
*			<xs:enumeration value="registry"/>
*			<xs:enumeration value="mapping"/>
*			<xs:enumeration value="codelist"/>
*			<xs:enumeration value="categoryscheme"/>
*			<xs:enumeration value="conceptscheme"/>
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
public class PackageTypeCodelistType {

    public static final List<PackageTypeCodelistType> ENUM = new ArrayList<PackageTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();

    public static final String TARGET_BASE = addString("base");
    public static final String TARGET_DATASTRUCTURE = addString("datastructure");
    public static final String TARGET_METADATASTRUCTURE = addString("metadatastructure");
    public static final String TARGET_PROCESS = addString("process");
    public static final String TARGET_REGISTRY = addString("registry");
    public static final String TARGET_MAPPING = addString("mapping");
    public static final String TARGET_CODELIST = addString("codelist");
    public static final String TARGET_CATEGORYSCHEME = addString("categoryscheme");
    public static final String TARGET_CONCEPTSCHEME = addString("conceptscheme");

    public static final PackageTypeCodelistType BASE = add(TARGET_BASE);
    public static final PackageTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final PackageTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    public static final PackageTypeCodelistType PROCESS = add(TARGET_PROCESS);
    public static final PackageTypeCodelistType REGISTRY = add(TARGET_REGISTRY);
    public static final PackageTypeCodelistType MAPPING = add(TARGET_MAPPING);
    public static final PackageTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final PackageTypeCodelistType CATEGORYSCHEME = add(TARGET_CATEGORYSCHEME);
    public static final PackageTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);
// Utility
    private static PackageTypeCodelistType add(String s){
        PackageTypeCodelistType b = new PackageTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }

    public static PackageTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static PackageTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in PackageTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public PackageTypeCodelistType(String s) {
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid CodeTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
