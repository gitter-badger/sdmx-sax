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
 *	<xs:simpleType name="MaintainableTypeCodelistType">
		<xs:annotation>
			<xs:documentation>MaintainableTypeCodelistType provides an enumeration of all maintainable objects.</xs:documentation>
		</xs:annotation>
		<xs:restriction base="ObjectTypeCodelistType">
			<xs:enumeration value="Any"/>
			<xs:enumeration value="AgencyScheme"/>
			<xs:enumeration value="AttachmentConstraint"/>
			<xs:enumeration value="Categorisation"/>
			<xs:enumeration value="CategoryScheme"/>
			<xs:enumeration value="Codelist"/>
			<xs:enumeration value="ConceptScheme"/>
			<xs:enumeration value="Constraint"/>
			<xs:enumeration value="ContentConstraint"/>
			<xs:enumeration value="Dataflow"/>
			<xs:enumeration value="DataConsumerScheme"/>
			<xs:enumeration value="DataProviderScheme"/>
			<xs:enumeration value="DataStructure"/>
			<xs:enumeration value="HierarchicalCodelist"/>
			<xs:enumeration value="Metadataflow"/>
			<xs:enumeration value="MetadataStructure"/>
			<xs:enumeration value="OrganisationScheme"/>
			<xs:enumeration value="OrganisationUnitScheme"/>
			<xs:enumeration value="Process"/>
			<xs:enumeration value="ProvisionAgreement"/>
			<xs:enumeration value="ReportingTaxonomy"/>
			<xs:enumeration value="StructureSet"/>
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
public class MaintainableTypeCodelistType extends ObjectTypeCodelistType {

    public static final List<MaintainableTypeCodelistType> ENUM = new ArrayList<MaintainableTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_ANY = addString("Any");
    public static final String TARGET_AGENCYSCHEME = addString("AgencyScheme");
    public static final String TARGET_ATTACHMENTCONSTRAINT = addString("AttachmentConstraint");
    public static final String TARGET_CATEGORISATION = addString("Categorisation");
    public static final String TARGET_CATEGORYSCHEME = addString("CategoryScheme");
    public static final String TARGET_CODELIST = addString("Codelist");
    public static final String TARGET_CONCEPTSCHEME = addString("ConceptScheme");
    public static final String TARGET_CONSTRAINT = addString("Constraint");
    public static final String TARGET_CONTENTCONSTRAINT = addString("ContentConstraint");
    public static final String TARGET_DATAFLOW = addString("Dataflow");
    public static final String TARGET_DATACONSUMERSCHEME = addString("DataConsumerScheme");
    public static final String TARGET_DATAPROVIDERSCHEME = addString("DataProviderScheme");
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final String TARGET_HIERARCHICALCODELIST = addString("HierarchicalCodelist");
    public static final String TARGET_METADATAFLOW = addString("Metadataflow");
    public static final String TARGET_METADATASTRUCTURE = addString("MetadataStructure");
    public static final String TARGET_ORGANISATIONSCHEME = addString("OrganisationScheme");
    public static final String TARGET_ORGANISATIONUNITSCHEME = addString("OrganisationUnitScheme");
    public static final String TARGET_PROCESS = addString("Process");
    public static final String TARGET_PROVISIONAGREEMENT = addString("ProvisionAgreement");
    public static final String TARGET_REPORTINGTAXONOMY = addString("ReportingTaxonomy");
    public static final String TARGET_STRUCTURESET = addString("StructureSet");

    public static final MaintainableTypeCodelistType ANY = add(TARGET_ANY);
    public static final MaintainableTypeCodelistType AGENCYSCHEME = add(TARGET_AGENCYSCHEME);
    public static final MaintainableTypeCodelistType ATTACHMENTCONSTRAINT = add(TARGET_ATTACHMENTCONSTRAINT);
    public static final MaintainableTypeCodelistType CATEGORISATION = add(TARGET_CATEGORISATION);
    public static final MaintainableTypeCodelistType CATEGORYSCHEME = add(TARGET_CATEGORYSCHEME);
    public static final MaintainableTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final MaintainableTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);
    public static final MaintainableTypeCodelistType CONSTRAINT = add(TARGET_CONSTRAINT);
    public static final MaintainableTypeCodelistType CONTENTCONSTRAINT = add(TARGET_CONTENTCONSTRAINT);
    public static final MaintainableTypeCodelistType DATAFLOW = add(TARGET_DATAFLOW);
    public static final MaintainableTypeCodelistType DATACONSUMERSCHEME = add(TARGET_DATACONSUMERSCHEME);
    public static final MaintainableTypeCodelistType DATAPROVIDERSCHEME = add(TARGET_DATAPROVIDERSCHEME);
    public static final MaintainableTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final MaintainableTypeCodelistType HIERARCHICALCODELIST = add(TARGET_HIERARCHICALCODELIST);
    public static final MaintainableTypeCodelistType METADATAFLOW = add(TARGET_METADATAFLOW);
    public static final MaintainableTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    public static final MaintainableTypeCodelistType ORGANISATIONSCHEME = add(TARGET_ORGANISATIONSCHEME);
    public static final MaintainableTypeCodelistType ORGANISATIONUNITSCHEME = add(TARGET_ORGANISATIONUNITSCHEME);
    public static final MaintainableTypeCodelistType PROCESS = add(TARGET_PROCESS);
    public static final MaintainableTypeCodelistType PROVISIONAGREEMENT = add(TARGET_PROVISIONAGREEMENT);
    public static final MaintainableTypeCodelistType REPORTINGTAXONOMY = add(TARGET_REPORTINGTAXONOMY);
    public static final MaintainableTypeCodelistType STRUCTURESET = add(TARGET_STRUCTURESET);

// Utility
    private static MaintainableTypeCodelistType add(String s){
        MaintainableTypeCodelistType b = new MaintainableTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static MaintainableTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static MaintainableTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in MaintainableTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public MaintainableTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid MaintainableTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
