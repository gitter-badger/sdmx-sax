/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *	<xs:simpleType name="OrganisationTypeCodelistType">
		<xs:annotation>
			<xs:documentation>OrganisationTypeCodelistType provides an enumeration of all organisation objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ItemTypeCodelistType">
			<xs:enumeration value="Agency"/>
			<xs:enumeration value="DataConsumer"/>
			<xs:enumeration value="DataProvider"/>
			<xs:enumeration value="OrganisationUnit"/>
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
public class OrganisationTypeCodelistType extends ItemTypeCodelistType {
    public static final List<OrganisationTypeCodelistType> ENUM = new ArrayList<OrganisationTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_AGENCY = addString("Agency");
    public static final String TARGET_DATACONSUMER = addString("DataConsumer");
    public static final String TARGET_DATAPROVIDER = addString("DataProvider");
    public static final String TARGET_ORGANISATIONUNIT = addString("OrganisationUnit");

    public static final OrganisationTypeCodelistType AGENCY = add(TARGET_AGENCY);
    public static final OrganisationTypeCodelistType DATACONSUMER = add(TARGET_DATACONSUMER);
    public static final OrganisationTypeCodelistType DATAPROVIDER = add(TARGET_DATAPROVIDER);
    public static final OrganisationTypeCodelistType ORGANISATIONUNI = add(TARGET_ORGANISATIONUNIT);

// Utility
    private static OrganisationTypeCodelistType add(String s){
        OrganisationTypeCodelistType b = new OrganisationTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static OrganisationTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static OrganisationTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in OrganisationTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public OrganisationTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid OrganisationTypeCodelistType");
        this.target=s;
    }
    
    public String toString() { return target; }
}
