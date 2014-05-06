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
 *	<xs:simpleType name="ItemTypeCodelistType">
		<xs:annotation>
			<xs:documentation>ItemTypeCodelistType provides an enumeration of all item objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ObjectTypeCodelistType">
			<xs:enumeration value="Agency"/>
			<xs:enumeration value="Category"/>
			<xs:enumeration value="Code"/>
			<xs:enumeration value="Concept"/>
			<xs:enumeration value="DataConsumer"/>
			<xs:enumeration value="DataProvider"/>
			<xs:enumeration value="OrganisationUnit"/>
			<xs:enumeration value="ReportingCategory"/>
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
public class ItemTypeCodelistType extends ObjectTypeCodelistType {

    public static final List<ItemTypeCodelistType> ENUM = new ArrayList<ItemTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_AGENCY = addString("Agency");
    public static final String TARGET_CATEGORY = addString("Category");
    public static final String TARGET_CODE = addString("Code");
    public static final String TARGET_CONCEPT = addString("Concept");
    public static final String TARGET_DATACONSUMER = addString("DataConsumer");
    public static final String TARGET_DATAPROVIDER = addString("DataProvider");
    public static final String TARGET_ORGANISATIONUNIT = addString("OrganisationUnit");
    public static final String TARGET_REPORTINGCATEGORY = addString("ReportingCategory");
    
    public static final ItemTypeCodelistType AGENCY = add(TARGET_AGENCY);
    public static final ItemTypeCodelistType CATEGORY = add(TARGET_CATEGORY);
    public static final ItemTypeCodelistType CODE = add(TARGET_CODE);
    public static final ItemTypeCodelistType CONCEPT = add(TARGET_CONCEPT);
    public static final ItemTypeCodelistType DATACONSUMER = add(TARGET_DATACONSUMER);
    public static final ItemTypeCodelistType DATAPROVIDER = add(TARGET_DATAPROVIDER);
    public static final ItemTypeCodelistType ORGANISATIONUNI = add(TARGET_ORGANISATIONUNIT);
    public static final ItemTypeCodelistType REPORTINGCATEGORY = add(TARGET_REPORTINGCATEGORY);
    
    // This isn't listed as a valid value for this type, however
    // the 'Dataflow' type needs this to be here.
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final ItemTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    
// Utility
    private static ItemTypeCodelistType add(String s){
        ItemTypeCodelistType b = new ItemTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static ItemTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static ItemTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in ItemTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public ItemTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ItemTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
