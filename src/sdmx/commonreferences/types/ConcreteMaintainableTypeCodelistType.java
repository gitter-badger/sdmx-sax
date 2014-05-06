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
public class ConcreteMaintainableTypeCodelistType extends MaintainableTypeCodelistType {
    public static final List<ConcreteMaintainableTypeCodelistType> ENUM = new ArrayList<ConcreteMaintainableTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_AGENCYSCHEME = addString("AgencyScheme");
    public static final String TARGET_ATTACHMENTCONSTRAINT = addString("AttachmentConstraint");
    public static final String TARGET_CATEGORISATION = addString("Categorisation");
    public static final String TARGET_CATEGORYSCHEME = addString("CategoryScheme");
    public static final String TARGET_CODELIST = addString("Codelist");
    public static final String TARGET_CONCEPTSCHEME = addString("ConceptScheme");
    public static final String TARGET_CONTENTCONSTRAINT = addString("ContentConstraint");
    public static final String TARGET_DATAFLOW = addString("Dataflow");
    public static final String TARGET_DATACONSUMERSCHEME = addString("DataConsumerScheme");
    public static final String TARGET_DATAPROVIDERSCHEME = addString("DataProviderScheme");
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final String TARGET_HIERARCHICALCODELIST = addString("HierarchicalCodelist");
    public static final String TARGET_METADATAFLOW = addString("Metadataflow");
    public static final String TARGET_METADATASTRUCTURE = addString("MetadataStructure");
    public static final String TARGET_ORGANISATIONUNITSCHEME = addString("OrganisationUnitScheme");
    public static final String TARGET_PROCESS = addString("Process");
    public static final String TARGET_PROVISIONAGREEMENT = addString("ProvisionAgreement");
    public static final String TARGET_REPORTINGTAXONOMY = addString("ReportingTaxonomy");
    public static final String TARGET_STRUCTURESET = addString("StructureSet");

    public static final ConcreteMaintainableTypeCodelistType ANY = add(TARGET_ANY);
    public static final ConcreteMaintainableTypeCodelistType AGENCYSCHEME = add(TARGET_AGENCYSCHEME);
    public static final ConcreteMaintainableTypeCodelistType ATTACHMENTCONSTRAINT = add(TARGET_ATTACHMENTCONSTRAINT);
    public static final ConcreteMaintainableTypeCodelistType CATEGORISATION = add(TARGET_CATEGORISATION);
    public static final ConcreteMaintainableTypeCodelistType CATEGORYSCHEME = add(TARGET_CATEGORYSCHEME);
    public static final ConcreteMaintainableTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final ConcreteMaintainableTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);
    public static final ConcreteMaintainableTypeCodelistType CONSTRAINT = add(TARGET_CONSTRAINT);
    public static final ConcreteMaintainableTypeCodelistType CONTENTCONSTRAINT = add(TARGET_CONTENTCONSTRAINT);
    public static final ConcreteMaintainableTypeCodelistType DATAFLOW = add(TARGET_DATAFLOW);
    public static final ConcreteMaintainableTypeCodelistType DATACONSUMERSCHEME = add(TARGET_DATACONSUMERSCHEME);
    public static final ConcreteMaintainableTypeCodelistType DATAPROVIDERSCHEME = add(TARGET_DATAPROVIDERSCHEME);
    public static final ConcreteMaintainableTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final ConcreteMaintainableTypeCodelistType HIERARCHICALCODELIST = add(TARGET_HIERARCHICALCODELIST);
    public static final ConcreteMaintainableTypeCodelistType METADATAFLOW = add(TARGET_METADATAFLOW);
    public static final ConcreteMaintainableTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    public static final ConcreteMaintainableTypeCodelistType ORGANISATIONUNITSCHEME = add(TARGET_ORGANISATIONUNITSCHEME);
    public static final ConcreteMaintainableTypeCodelistType PROCESS = add(TARGET_PROCESS);
    public static final ConcreteMaintainableTypeCodelistType PROVISIONAGREEMENT = add(TARGET_PROVISIONAGREEMENT);
    public static final ConcreteMaintainableTypeCodelistType REPORTINGTAXONOMY = add(TARGET_REPORTINGTAXONOMY);
    public static final ConcreteMaintainableTypeCodelistType STRUCTURESET = add(TARGET_STRUCTURESET);

// Utility
    private static ConcreteMaintainableTypeCodelistType add(String s){
        ConcreteMaintainableTypeCodelistType b = new ConcreteMaintainableTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static ConcreteMaintainableTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static ConcreteMaintainableTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in ConcreteMaintainableTypeCodelistType enumeration!");
    }
// Instance
    private String target = null;
    public ConcreteMaintainableTypeCodelistType(String s) {
        super(s);
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ConcreteMaintainableTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
