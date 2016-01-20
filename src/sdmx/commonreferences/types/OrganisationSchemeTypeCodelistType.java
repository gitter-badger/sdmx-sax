/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

/**
 *
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
public class OrganisationSchemeTypeCodelistType extends ItemSchemeTypeCodelistType  {

    public static final List<OrganisationSchemeTypeCodelistType> ENUM = new ArrayList<OrganisationSchemeTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_AGENCYSCHEME = addString("AgencyScheme");
    public static final String TARGET_DATACONSUMERSCHEME = addString("DataConsumerScheme");
    public static final String TARGET_DATAPROVIDERSCHEME = addString("DataProviderScheme");
    public static final String TARGET_ORGANISATIONUNITSCHEME = addString("OrganisationUnitScheme");
    
    public static final OrganisationSchemeTypeCodelistType AGENCYSCHEME = add(TARGET_AGENCYSCHEME);
    public static final OrganisationSchemeTypeCodelistType DATACONSUMERSCHEME = add(TARGET_DATACONSUMERSCHEME);
    public static final OrganisationSchemeTypeCodelistType DATAPROVIDERSCHEME = add(TARGET_DATAPROVIDERSCHEME);
    public static final OrganisationSchemeTypeCodelistType ORGANISATIONUNITSCHEME = add(TARGET_ORGANISATIONUNITSCHEME);


// Utility
    private static OrganisationSchemeTypeCodelistType add(String s){
        OrganisationSchemeTypeCodelistType b = new OrganisationSchemeTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static OrganisationSchemeTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static OrganisationSchemeTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in OrganisationSchemeTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public OrganisationSchemeTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid OrganisationSchemeTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
