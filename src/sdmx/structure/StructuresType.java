/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.commonreferences.DataStructureRefType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.ItemSchemeReferenceBaseType;
import sdmx.commonreferences.NestedIDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.StructureOrUsageReferenceType;
import sdmx.commonreferences.StructureReferenceType;
import sdmx.commonreferences.VersionType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.message.DataStructure;
import sdmx.message.DataStructureQueryMessage;
import sdmx.message.StructureType;
import sdmx.registry.RegistryUtil;
import sdmx.structure.base.MaintainableType;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.concept.ConceptSchemeType;
import sdmx.structure.concept.ConceptType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;

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
public class StructuresType implements Registry {

    private List<StructureOrUsageReferenceType> relatedStructure;
    private DataflowsType dataFlows = null;
    private MetadataflowsType metadataFlows = null;
    private CategorySchemesType categorySchemes = null;
    private CategorisationsType categorisations = null;
    private CodelistsType codelists = null;
    private HierarchicalCodelistsType hierarchicalCodelists = null;
    private ConceptsType concepts = null;
    private MetadataStructuresType metadataStructures = null;
    private DataStructuresType dataStructures = null;
    private StructureSetsType structureSets = null;
    private ReportingTaxonomiesType reportingTaxonomies = null;
    private ProcessesType processes = null;
    private ConstraintsType constraints = null;
    private ProvisionAgreementsType provisionAgreements = null;

    /**
     * @return the relatedStructure
     */
    public List<StructureOrUsageReferenceType> getRelatedStructure() {
        return relatedStructure;
    }

    /**
     * @param relatedStructure the relatedStructure to set
     */
    public void setRelatedStructure(List<StructureOrUsageReferenceType> relatedStructure) {
        this.relatedStructure = relatedStructure;
    }

    /**
     * @return the dataFlows
     */
    public DataflowsType getDataflows() {
        return dataFlows;
    }

    /**
     * @param dataFlows the dataFlows to set
     */
    public void setDataflows(DataflowsType dataFlows) {
        this.dataFlows = dataFlows;
    }

    /**
     * @return the metadataFlows
     */
    public MetadataflowsType getMetadataFlows() {
        return metadataFlows;
    }

    /**
     * @param metadataFlows the metadataFlows to set
     */
    public void setMetadataFlows(MetadataflowsType metadataFlows) {
        this.metadataFlows = metadataFlows;
    }

    /**
     * @return the categorySchemes
     */
    public CategorySchemesType getCategorySchemes() {
        return categorySchemes;
    }

    /**
     * @param categorySchemes the categorySchemes to set
     */
    public void setCategorySchemes(CategorySchemesType categorySchemes) {
        this.categorySchemes = categorySchemes;
    }

    /**
     * @return the categorisations
     */
    public CategorisationsType getCategorisations() {
        return categorisations;
    }

    /**
     * @param categorisations the categorisations to set
     */
    public void setCategorisations(CategorisationsType categorisations) {
        this.categorisations = categorisations;
    }

    /**
     * @return the codelists
     */
    public CodelistsType getCodelists() {
        return codelists;
    }

    /**
     * @param codelists the codelists to set
     */
    public void setCodelists(CodelistsType codelists) {
        this.codelists = codelists;
    }

    /**
     * @return the hierarchicalCodelists
     */
    public HierarchicalCodelistsType getHierarchicalCodelists() {
        return hierarchicalCodelists;
    }

    /**
     * @param hierarchicalCodelists the hierarchicalCodelists to set
     */
    public void setHierarchicalCodelists(HierarchicalCodelistsType hierarchicalCodelists) {
        this.hierarchicalCodelists = hierarchicalCodelists;
    }

    /**
     * @return the concepts
     */
    public ConceptsType getConcepts() {
        return concepts;
    }

    /**
     * @param concepts the concepts to set
     */
    public void setConcepts(ConceptsType concepts) {
        this.concepts = concepts;
    }

    /**
     * @return the metadataStructures
     */
    public MetadataStructuresType getMetadataStructures() {
        return metadataStructures;
    }

    /**
     * @param metadataStructures the metadataStructures to set
     */
    public void setMetadataStructures(MetadataStructuresType metadataStructures) {
        this.metadataStructures = metadataStructures;
    }

    /**
     * @return the dataStructures
     */
    public DataStructuresType getDataStructures() {
        return dataStructures;
    }

    /**
     * @param dataStructures the dataStructures to set
     */
    public void setDataStructures(DataStructuresType dataStructures) {
        this.dataStructures = dataStructures;
    }

    /**
     * @return the structureSets
     */
    public StructureSetsType getStructureSets() {
        return structureSets;
    }

    /**
     * @param structureSets the structureSets to set
     */
    public void setStructureSets(StructureSetsType structureSets) {
        this.structureSets = structureSets;
    }

    /**
     * @return the reportingTaxonomies
     */
    public ReportingTaxonomiesType getReportingTaxonomies() {
        return reportingTaxonomies;
    }

    /**
     * @param reportingTaxonomies the reportingTaxonomies to set
     */
    public void setReportingTaxonomies(ReportingTaxonomiesType reportingTaxonomies) {
        this.reportingTaxonomies = reportingTaxonomies;
    }

    /**
     * @return the processes
     */
    public ProcessesType getProcesses() {
        return processes;
    }

    /**
     * @param processes the processes to set
     */
    public void setProcesses(ProcessesType processes) {
        this.processes = processes;
    }

    /**
     * @return the constraints
     */
    public ConstraintsType getConstraints() {
        return constraints;
    }

    /**
     * @param constraints the constraints to set
     */
    public void setConstraints(ConstraintsType constraints) {
        this.constraints = constraints;
    }

    /**
     * @return the provisionAgreements
     */
    public ProvisionAgreementsType getProvisionAgreements() {
        return provisionAgreements;
    }

    /**
     * @param provisionAgreements the provisionAgreements to set
     */
    public void setProvisionAgreements(ProvisionAgreementsType provisionAgreements) {
        this.provisionAgreements = provisionAgreements;
    }

    @Override
    public void load(StructureType struct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void unload(StructureType struct) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id, VersionType version) {
        DataStructureType found = getDataStructures().findDataStructure(agency, id, version);
        if (found != null) {
            return found;
        }
        return null;
    }

    @Override
    public DataStructureType findDataStructure(NestedNCNameIDType agency, IDType id) {
        DataStructureType found = getDataStructures().findDataStructure(agency, id);
        if (found != null) {
            return found;
        }
        return null;
    }

    @Override
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType agencyID, ConceptReferenceType conceptRef) {
        ConceptsType ct = getConcepts();
        ConceptSchemeType cs = null;
        if (ct != null) {
            cs = ct.findConceptScheme(agencyID, conceptRef);
        }
        if (cs != null) {
            return cs;
        }
        return null;

    }

    @Override
    public CodelistType findCodelist(ItemSchemeReferenceBaseType enumeration) {
        if( getCodelists()==null ) return null;
        CodelistType cs = getCodelists().findCodelist(enumeration);
        if (cs != null) {
            return cs;
        }
        return null;
    }

    @Override
    public CodelistType findCodelistById(IDType id) {
        CodelistType cl = getCodelists().findCodelistById(id);
        if (cl != null) {
            return cl;
        }
        return null;
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist, VersionType codelistVersion) {
        return findCodelist(codelistAgency.getString(), codelist.getString(), codelistVersion == null ? null : codelistVersion.getString());
    }

    @Override
    public CodelistType findCodelist(NestedNCNameIDType codelistAgency, IDType codelist) {
        CodelistType cl = getCodelists().findCodelist(codelistAgency, codelist);
        if (cl != null) {
            return cl;
        }
        return null;
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist, String codelistVersion) {
        if( getCodelists()==null ) return null;
        CodelistType cl = getCodelists().findCodelist(codelistAgency, codelist, codelistVersion);
        if (cl != null) {
            return cl;
        }
        return null;
    }

    @Override
    public CodelistType findCodelist(String codelistAgency, String codelist) {
        CodelistType cl = getCodelists().findCodelist(new NestedNCNameIDType(codelistAgency), new IDType(codelist));
        if (cl != null) {
            return cl;
        }
        return null;
    }

    @Override
    public ConceptSchemeType findConceptScheme(NestedNCNameIDType csa, IDType csi) {
        if( getConcepts()==null ) return null;
        ConceptSchemeType cs = getConcepts().findConceptScheme(csa, csi);
        if (cs != null) {
            return cs;
        }
        return null;
    }

    @Override
    public ConceptSchemeType findConceptSchemeById(IDType id) {
        ConceptSchemeType cs = getConcepts().findConceptSchemeById(id);
        if (cs != null) {
            return cs;
        }
        return null;
    }

    public ConceptType findConcept(NestedNCNameIDType agency, IDType id) {
        ConceptSchemeType cs = findConceptScheme(agency, id);
        if (cs == null) {
            // This is for ABS Data Structures -> the OBS_VALUE
            // has an agency of 'OECD' and this agency can't be inferred from the
            // keyfamily agency, or sender agency.
            //System.out.println("Agency="+agency.toString()+": id="+id.toString());
            cs = findConceptScheme(agency,new IDType("STANDALONE_CONCEPT_SCHEME"));
            //System.out.println("Cs="+cs);
            //for(int i=0;i<concepts.getConceptSchemes().size();i++) {
            //    System.out.println("Cs="+concepts.getConceptSchemes().get(i).getId().toString());
            //}
            return cs.findConcept(id);
        }
        return cs.findConcept(id);
    }

    @Override
    public ConceptType findConcept(IDType id) {
            ConceptType ct = getConcepts().findConcept(id);
            if (ct != null) {
                return ct;
            }
            return null;
    }

    @Override
    public List<DataflowType> listDataflows() {
        return getDataflows().getDataflows();
    }

    @Override
    public StructureType query(DataStructureQueryMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DataMessage query(DataQueryMessage message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reset() {
        
    }

    public MaintainableType resolve(StructureReferenceType ref) {
        return RegistryUtil.resolve(this, ref);
    }

    @Override
    public DataflowType findDataflow(NestedNCNameIDType agency, IDType id, VersionType vers) {
        return dataFlows.findDataflow(agency, id, vers);
    }
}
