/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="ItemSchemeTypeCodelistType">
		<xs:annotation>
			<xs:documentation>ItemSchemeTypeCodelistType provides an enumeration of all item scheme objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="MaintainableTypeCodelistType">
			<xs:enumeration value="AgencyScheme"/>
			<xs:enumeration value="CategoryScheme"/>
			<xs:enumeration value="Codelist"/>
			<xs:enumeration value="ConceptScheme"/>
			<xs:enumeration value="DataConsumerScheme"/>
			<xs:enumeration value="DataProviderScheme"/>
			<xs:enumeration value="OrganisationUnitScheme"/>
			<xs:enumeration value="ReportingTaxonomy"/>
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
public class ItemSchemeTypeCodelistType extends ObjectTypeCodelistType {

    public static final List<ItemSchemeTypeCodelistType> ENUM = new ArrayList<ItemSchemeTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    public static final String TARGET_AGENCYSCHEME = addString("AgencyScheme");
    public static final String TARGET_CATEGORYSCHEME = addString("CategoryScheme");
    public static final String TARGET_CODELIST = addString("Codelist");
    public static final String TARGET_CONCEPTSCHEME = addString("ConceptScheme");
    public static final String TARGET_DATACONSUMERSCHEME = addString("DataConsumerScheme");
    public static final String TARGET_DATAPROVIDERSCHEME = addString("DataProviderScheme");
    public static final String TARGET_ORGANISATIONUNITSCHEME = addString("OrganisationUnitScheme");
    public static final String TARGET_REPORTINGTAXONOMY = addString("ReportingTaxonomy");

    public static final ItemSchemeTypeCodelistType AGENCYSCHEME = add(TARGET_AGENCYSCHEME);
    public static final ItemSchemeTypeCodelistType CATEGORYSCHEME = add(TARGET_CATEGORYSCHEME);
    public static final ItemSchemeTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final ItemSchemeTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);
    public static final ItemSchemeTypeCodelistType DATACONSUMERSCHEME= add(TARGET_DATACONSUMERSCHEME);
    public static final ItemSchemeTypeCodelistType DATAPROVIDERSCHEME = add(TARGET_DATAPROVIDERSCHEME);
    public static final ItemSchemeTypeCodelistType ORGANISATIONUNITSCHEME = add(TARGET_ORGANISATIONUNITSCHEME);
    public static final ItemSchemeTypeCodelistType REPORTINGTAXONOMY = add(TARGET_REPORTINGTAXONOMY);
    

// Utility
    private static ItemSchemeTypeCodelistType add(String s){
        ItemSchemeTypeCodelistType b = new ItemSchemeTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static ItemSchemeTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).toString().equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static ItemSchemeTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).toString().equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in ItemSchemeTypeCodelistType enumeration!");
    }
// Instance
    public ItemSchemeTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ObjectTypeCodelistType");
    }
}
