/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences.types;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;
import sun.reflect.generics.tree.BaseType;

/**
 *	<xs:simpleType name="ObjectTypeCodelistType">
*		<xs:annotation>
*			<xs:documentation>ObjectTypeCodelistType provides an enumeration of all objects outside of the base infomration model class. This includes some abstract object types such as Organsiation and Constraint.</xs:documentation>
*		</xs:annotation>
*		<xs:restriction base="xs:string">
*			<xs:enumeration value="Any"/>
*			<xs:enumeration value="Agency"/>
*			<xs:enumeration value="AgencyScheme"/>
*			<xs:enumeration value="AttachmentConstraint"/>
*			<xs:enumeration value="Attribute"/>
*			<xs:enumeration value="AttributeDescriptor"/>
*			<xs:enumeration value="Categorisation"/>
*			<xs:enumeration value="Category"/>
*			<xs:enumeration value="CategorySchemeMap"/>
*			<xs:enumeration value="CategoryScheme"/>
*			<xs:enumeration value="Code"/>
*			<xs:enumeration value="CodeMap"/>
*			<xs:enumeration value="Codelist"/>
*			<xs:enumeration value="CodelistMap"/>
*			<xs:enumeration value="ComponentMap"/>
*			<xs:enumeration value="Concept"/>
*			<xs:enumeration value="ConceptMap"/>
*			<xs:enumeration value="ConceptScheme"/>
*			<xs:enumeration value="ConceptSchemeMap"/>
*			<xs:enumeration value="Constraint"/>
*			<xs:enumeration value="ConstraintTarget"/>
*			<xs:enumeration value="ContentConstraint"/>
*			<xs:enumeration value="Dataflow"/>
*			<xs:enumeration value="DataConsumer"/>
*			<xs:enumeration value="DataConsumerScheme"/>
*			<xs:enumeration value="DataProvider"/>
*			<xs:enumeration value="DataProviderScheme"/>
*			<xs:enumeration value="DataSetTarget"/>
*			<xs:enumeration value="DataStructure"/>
*			<xs:enumeration value="Dimension"/>
*			<xs:enumeration value="DimensionDescriptor"/>
*			<xs:enumeration value="DimensionDescriptorValuesTarget"/>
*			<xs:enumeration value="GroupDimensionDescriptor"/>
*			<xs:enumeration value="HierarchicalCode"/>
*			<xs:enumeration value="HierarchicalCodelist"/>
*			<xs:enumeration value="Hierarchy"/>
*			<xs:enumeration value="HybridCodelistMap"/>
*			<xs:enumeration value="HybridCodeMap"/>
*			<xs:enumeration value="IdentifiableObjectTarget"/>
*			<xs:enumeration value="Level"/>
*			<xs:enumeration value="MeasureDescriptor"/>
*			<xs:enumeration value="MeasureDimension"/>
*			<xs:enumeration value="Metadataflow"/>
*			<xs:enumeration value="MetadataAttribute"/>
*			<xs:enumeration value="MetadataSet"/>
*			<xs:enumeration value="MetadataStructure"/>
*			<xs:enumeration value="MetadataTarget"/>
*			<xs:enumeration value="Organisation"/>
*			<xs:enumeration value="OrganisationMap"/>
*			<xs:enumeration value="OrganisationScheme"/>
*			<xs:enumeration value="OrganisationSchemeMap"/>
*			<xs:enumeration value="OrganisationUnit"/>
*			<xs:enumeration value="OrganisationUnitScheme"/>
*			<xs:enumeration value="PrimaryMeasure"/>
*			<xs:enumeration value="Process"/>
*			<xs:enumeration value="ProcessStep"/>
*			<xs:enumeration value="ProvisionAgreement"/>
*			<xs:enumeration value="ReportingCategory"/>
*			<xs:enumeration value="ReportingCategoryMap"/>
*			<xs:enumeration value="ReportingTaxonomy"/>
*			<xs:enumeration value="ReportingTaxonomyMap"/>
*			<xs:enumeration value="ReportingYearStartDay"/>
*			<xs:enumeration value="ReportPeriodTarget"/>
*			<xs:enumeration value="ReportStructure"/>
*			<xs:enumeration value="StructureMap"/>
*			<xs:enumeration value="StructureSet"/>
*			<xs:enumeration value="TimeDimension"/>
*			<xs:enumeration value="Transition"/>
*		</xs:restriction>
*	</xs:simpleType>
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
public class ObjectTypeCodelistType {

    public static final List<ObjectTypeCodelistType> ENUM = new ArrayList<ObjectTypeCodelistType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String TARGET_ANY = addString("Any");
    public static final String TARGET_AGENCY = addString("Agency");
    public static final String TARGET_AGENCYSCHEME = addString("AgencyScheme");
    public static final String TARGET_ATTACHMENTCONSTRAINT = addString("AttachmentConstraint");
    public static final String TARGET_ATTRIBUTE = addString("Attribute");
    public static final String TARGET_ATTRIBUTEDESCRIPTOR = addString("AttributeDescriptor");
    public static final String TARGET_CATEGORISATION = addString("Categorisation");
    public static final String TARGET_CATEGORY = addString("Category");
    public static final String TARGET_CATEGORYSCHEMEMAP = addString("CategorySchemeMap");
    public static final String TARGET_CATEGORYSCHEME = addString("CategoryScheme");
    public static final String TARGET_CODE = addString("Code");
    public static final String TARGET_CODEMAP = addString("CodeMap");
    public static final String TARGET_CODELIST = addString("Codelist");
    public static final String TARGET_CODELISTMAP = addString("CodelistMap");
    public static final String TARGET_COMPONENTMAP = addString("ComponentMap");
    public static final String TARGET_CONCEPT = addString("Concept");
    public static final String TARGET_CONCEPTMAP = addString("ConceptMap");
    public static final String TARGET_CONCEPTSCHEME = addString("ConceptScheme");
    public static final String TARGET_CONCEPTSCHEMEMAP = addString("ConceptSchemeMap");
    public static final String TARGET_CONSTRAINT = addString("Constraint");
    public static final String TARGET_CONSTRAINTARGET = addString("ConstraintTarget");
    public static final String TARGET_CONTENTCONSTRAINT = addString("ContentConstraint");
    public static final String TARGET_DATAFLOW = addString("Dataflow");
    public static final String TARGET_DATACONSUMER = addString("DataConsumer");
    public static final String TARGET_DATACONSUMERSCHEME = addString("DataConsumerScheme");
    public static final String TARGET_DATAPROVIDER = addString("DataProvider");
    public static final String TARGET_DATAPROVIDERSCHEME = addString("DataProviderScheme");
    public static final String TARGET_DATASETTARGET = addString("DataSetTarget");
    public static final String TARGET_DATASTRUCTURE = addString("DataStructure");
    public static final String TARGET_DIMENSION = addString("Dimension");
    public static final String TARGET_DIMENSIONDESCRIPTOR = addString("DimensionDescriptor");
    public static final String TARGET_DIMENSIONDESCRIPTORVALUESTARGET = addString("DimensionDescriptorValuesTarget");
    public static final String TARGET_GROUPDIMENSIONDESCRIPTOR = addString("GroupDimensionDescriptor");
    public static final String TARGET_HIERARCHICALCODE = addString("HierarchicalCode");
    public static final String TARGET_HIERARCHICALCODELIST = addString("HierarchicalCodelist");
    public static final String TARGET_HIERARCHY = addString("Hierarchy");
    public static final String TARGET_HYBRIDCODELISTMAP = addString("HybridCodelistMap");
    public static final String TARGET_HYBRIDCODEMAP = addString("HybridCodeMap");
    public static final String TARGET_IDENTIFIABLEOBJECTTARGET = addString("IdentifiableObjectTarget");
    public static final String TARGET_LEVEL = addString("Level");
    public static final String TARGET_MEASUREDESCRIPTOR = addString("MeasureDescriptor");
    public static final String TARGET_MEASUREDIMENSION = addString("MeasureDimension");
    public static final String TARGET_METADATAFLOW = addString("Metadataflow");
    public static final String TARGET_METADATAATTRIBUTE = addString("MetadataAttribute");
    public static final String TARGET_METADATASET = addString("MetadataSet");
    public static final String TARGET_METADATASTRUCTURE = addString("MetadataStructure");
    public static final String TARGET_METADATATARGET = addString("MetadataTarget");
    public static final String TARGET_ORGANISATION = addString("Organisation");
    public static final String TARGET_ORGANISATIONMAP = addString("OrganisationMap");
    public static final String TARGET_ORGANISATIONSCHEME = addString("OrganisationScheme");
    public static final String TARGET_ORGANISATIONSCHEMEMAP = addString("OrganisationSchemeMap");
    public static final String TARGET_ORGANISATIONUNIT = addString("OrganisationUnit");
    public static final String TARGET_ORGANISATIONUNITSCHEME = addString("OrganisationUnitScheme");
    public static final String TARGET_PRIMARYMEASURE = addString("PrimaryMeasure");
    public static final String TARGET_PROCESS = addString("Process");
    public static final String TARGET_PROCESSSTEP = addString("ProcessStep");
    public static final String TARGET_PROVISIONAGREEMENT = addString("ProvisionAgreement");
    public static final String TARGET_REPORTINGCATEGORY = addString("ReportingCategory");
    public static final String TARGET_REPORTINGCATEGORYMAP = addString("ReportingCategoryMap");
    public static final String TARGET_REPORTINGTAXONOMY = addString("ReportingTaxonomy");
    public static final String TARGET_REPORTINGTAXONOMYMAP = addString("ReportingTaxonomyMap");
    public static final String TARGET_REPORTINGYEARSTARTDAY = addString("ReportingYearStartDay");
    public static final String TARGET_REPORTPERIODTARGET = addString("ReportPeriodTarget");
    public static final String TARGET_REPORTSTRUCTURE = addString("ReportStructure");
    public static final String TARGET_STRUCTUREMAP = addString("StructureMap");
    public static final String TARGET_STRUCTURESET = addString("StructureSet");
    public static final String TARGET_TIMEDIMENSION = addString("TimeDimension");
    public static final String TARGET_TRANSITION = addString("Transition");

    public static final ObjectTypeCodelistType ANY = add(TARGET_ANY);
    public static final ObjectTypeCodelistType AGENCY = add(TARGET_AGENCY);
    public static final ObjectTypeCodelistType AGENCYSCHEME = add(TARGET_AGENCYSCHEME);
    public static final ObjectTypeCodelistType ATTACHMENTCONSTRAINT = add(TARGET_ATTACHMENTCONSTRAINT);
    public static final ObjectTypeCodelistType ATTRIBUTE = add(TARGET_ATTRIBUTE);
    public static final ObjectTypeCodelistType ATTRIBUTEDESCRIPTOR = add(TARGET_ATTRIBUTEDESCRIPTOR);
    public static final ObjectTypeCodelistType CATEGORISATION = add(TARGET_CATEGORISATION);
    public static final ObjectTypeCodelistType CATEGORY = add(TARGET_CATEGORY);
    public static final ObjectTypeCodelistType CATEGORYSCHEMEMAP = add(TARGET_CATEGORYSCHEMEMAP);
    public static final ObjectTypeCodelistType CATEGORYSCHEME = add(TARGET_CATEGORYSCHEME);
    public static final ObjectTypeCodelistType CODE = add(TARGET_CODE);
    public static final ObjectTypeCodelistType CODEMAP = add(TARGET_CODE);
    public static final ObjectTypeCodelistType CODELIST = add(TARGET_CODELIST);
    public static final ObjectTypeCodelistType CODELISTMAP = add(TARGET_CODELISTMAP);
    public static final ObjectTypeCodelistType COMPONENTMAP = add(TARGET_COMPONENTMAP);
    public static final ObjectTypeCodelistType CONCEPT = add(TARGET_CONCEPT);
    public static final ObjectTypeCodelistType CONCEPTMAP = add(TARGET_CONCEPTMAP);
    public static final ObjectTypeCodelistType CONCEPTSCHEME = add(TARGET_CONCEPTSCHEME);
    public static final ObjectTypeCodelistType CONCEPTSCHEMEMAP = add(TARGET_CONCEPTSCHEMEMAP);
    public static final ObjectTypeCodelistType CONSTRAINT = add(TARGET_CONSTRAINT);
    public static final ObjectTypeCodelistType CONSTRAINTARGET = add(TARGET_CONSTRAINTARGET);
    public static final ObjectTypeCodelistType CONTENTCONSTRAINT = add(TARGET_CONTENTCONSTRAINT);
    public static final ObjectTypeCodelistType DATAFLOW = add(TARGET_DATAFLOW);
    public static final ObjectTypeCodelistType DATACONSUMER = add(TARGET_DATACONSUMER);
    public static final ObjectTypeCodelistType DATACONSUMERSCHEME = add(TARGET_DATACONSUMERSCHEME);
    public static final ObjectTypeCodelistType DATAPROVIDER = add(TARGET_DATAPROVIDER);
    public static final ObjectTypeCodelistType DATAPROVIDERSCHEME = add(TARGET_DATAPROVIDERSCHEME);
    public static final ObjectTypeCodelistType DATASETTARGET = add(TARGET_DATASETTARGET);
    public static final ObjectTypeCodelistType DATASTRUCTURE = add(TARGET_DATASTRUCTURE);
    public static final ObjectTypeCodelistType DIMENSION = add(TARGET_DIMENSION);
    public static final ObjectTypeCodelistType DIMENSIONDESCRIPTOR = add(TARGET_DIMENSIONDESCRIPTOR);
    public static final ObjectTypeCodelistType DIMENSIONDESCRIPTORVALUESTARGET = add(TARGET_DIMENSIONDESCRIPTORVALUESTARGET);
    public static final ObjectTypeCodelistType GROUPDIMENSIONDESCRIPTOR = add(TARGET_GROUPDIMENSIONDESCRIPTOR);
    public static final ObjectTypeCodelistType HIERARCHICALCODE = add(TARGET_HIERARCHICALCODE);
    public static final ObjectTypeCodelistType HIERARCHICALCODELIST = add(TARGET_HIERARCHICALCODELIST);
    public static final ObjectTypeCodelistType HIERARCHY = add(TARGET_HIERARCHY);
    public static final ObjectTypeCodelistType HYBRIDCODELISTMAP = add(TARGET_HYBRIDCODELISTMAP);
    public static final ObjectTypeCodelistType HYBRIDCODEMAP = add(TARGET_HYBRIDCODEMAP);
    public static final ObjectTypeCodelistType IDENTIFIABLEOBJECTTARGET = add(TARGET_IDENTIFIABLEOBJECTTARGET);
    public static final ObjectTypeCodelistType LEVEL = add(TARGET_LEVEL);
    public static final ObjectTypeCodelistType MEASUREDESCRIPTOR = add(TARGET_MEASUREDESCRIPTOR);
    public static final ObjectTypeCodelistType MEASUREDIMENSION = add(TARGET_MEASUREDIMENSION);
    public static final ObjectTypeCodelistType METADATAFLOW = add(TARGET_METADATAFLOW);
    public static final ObjectTypeCodelistType METADATAATTRIBUTE = add(TARGET_METADATAATTRIBUTE);
    public static final ObjectTypeCodelistType METADATASET = add(TARGET_METADATASET);
    public static final ObjectTypeCodelistType METADATASTRUCTURE = add(TARGET_METADATASTRUCTURE);
    public static final ObjectTypeCodelistType METADATATARGET = add(TARGET_METADATATARGET);
    public static final ObjectTypeCodelistType ORGANISATION = add(TARGET_ORGANISATION);
    public static final ObjectTypeCodelistType ORGANISATIONMAP = add(TARGET_ORGANISATIONMAP);
    public static final ObjectTypeCodelistType ORGANISATIONSCHEME = add(TARGET_ORGANISATIONSCHEME);
    public static final ObjectTypeCodelistType ORGANISATIONSCHEMEMAP = add(TARGET_ORGANISATIONSCHEMEMAP);
    public static final ObjectTypeCodelistType ORGANISATIONUNI = add(TARGET_ORGANISATIONUNIT);
    public static final ObjectTypeCodelistType ORGANISATIONUNITSCHEME = add(TARGET_ORGANISATIONUNITSCHEME);
    public static final ObjectTypeCodelistType PRIMARYMEASURE = add(TARGET_PRIMARYMEASURE);
    public static final ObjectTypeCodelistType PROCESS = add(TARGET_PROCESS);
    public static final ObjectTypeCodelistType PROCESSSTEP = add(TARGET_PROCESSSTEP);
    public static final ObjectTypeCodelistType PROVISIONAGREEMENT = add(TARGET_PROVISIONAGREEMENT);
    public static final ObjectTypeCodelistType REPORTINGCATEGORY = add(TARGET_REPORTINGCATEGORY);
    public static final ObjectTypeCodelistType REPORTINGCATEGORYMAP = add(TARGET_REPORTINGCATEGORYMAP);
    public static final ObjectTypeCodelistType REPORTINGTAXONOMY = add(TARGET_REPORTINGTAXONOMY);
    public static final ObjectTypeCodelistType REPORTINGTAXONOMYMAP = add(TARGET_REPORTINGTAXONOMYMAP);
    public static final ObjectTypeCodelistType REPORTINGYEARSTARTDAY = add(TARGET_REPORTINGYEARSTARTDAY);
    public static final ObjectTypeCodelistType REPORTPERIODTARGET = add(TARGET_REPORTPERIODTARGET);
    public static final ObjectTypeCodelistType REPORTSTRUCTURE = add(TARGET_REPORTSTRUCTURE);
    public static final ObjectTypeCodelistType STRUCTUREMAP = add(TARGET_STRUCTUREMAP);
    public static final ObjectTypeCodelistType STRUCTURESET = add(TARGET_STRUCTURESET);
    public static final ObjectTypeCodelistType TIMEDIMENSION = add(TARGET_TIMEDIMENSION);
    public static final ObjectTypeCodelistType TRANSITION = add(TARGET_TRANSITION);

// Utility
    private static ObjectTypeCodelistType add(String s){
        ObjectTypeCodelistType b = new ObjectTypeCodelistType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static ObjectTypeCodelistType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static ObjectTypeCodelistType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in enumeration! - ObjectypeCodelistType");
    }
// Instance
    private String target = null;
    public ObjectTypeCodelistType(String s) {
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid ObjectTypeCodelistType");
        this.target=s;
    }
    public String toString() { return target; }
}
