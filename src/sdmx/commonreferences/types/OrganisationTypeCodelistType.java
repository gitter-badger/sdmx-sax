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
