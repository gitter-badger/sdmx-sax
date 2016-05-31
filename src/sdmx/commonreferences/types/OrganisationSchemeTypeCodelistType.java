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
