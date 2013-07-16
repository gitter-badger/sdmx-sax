/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.List;
import sdmx.commonreferences.StructureOrUsageReferenceType;

/**
 *
 * @author James
 */
public class StructuresType {
    private List<StructureOrUsageReferenceType> relatedStructure;
    private DataflowsType dataFlows = null;
    private MetadataflowsType metadataFlows = null;
    private CategorySchemesType categorySchemes = null;
    private CategorisationsType categorisations = null;
    private CodelistsType codelists = null;
    private HierarchicalCodelistsType hierarchicalCodelists = null;
    private ConceptsType concepts = null;
    private MetadataStructuresType metadataStructures = null;
    private DataStructuresType dataStructures=null;
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

}
