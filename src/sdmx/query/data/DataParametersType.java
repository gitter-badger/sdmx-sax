/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import java.util.List;
import sdmx.common.TimeDataType;
import sdmx.common.TimeRangeValueType;
import sdmx.commonreferences.CategoryReferenceType;
import sdmx.commonreferences.DataProviderReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.DataflowReferenceType;
import sdmx.commonreferences.ProvisionAgreementReferenceType;
import sdmx.query.base.CodeValueType;
import sdmx.query.base.QueryIDType;

/**
 *
 * @author James
 */
public class DataParametersType {
    private List<QueryIDType> dataSetId = null;
    private List<DataProviderReferenceType> dataProvider = null;
    private List<DataStructureReferenceType> dataStructure = null;
    private List<DataflowReferenceType> dataflow = null;
    private List<ProvisionAgreementReferenceType> provisionAgreement = null;
    private List<CategoryReferenceType> category = null;
    private List<TimeRangeValueType> updated = null;
    private List<ConceptValueType> conceptValue = null;
    private List<CodeValueType> representationValue = null;
    private List<DimensionValueType> dimensionValue = null;
    private List<TimeDimensionValueType> timeDimensionValue=null;
    private List<AttributeValueType> attributeValue = null;
    private List<PrimaryMeasureValueType> primaryMeasureValue = null;
    private List<AttachmentConstraintReferenceType> attachmentConstraint = null;
    private List<TimeDataType> timeFormat = null;
    private List<DataParametersOrType> or = null;
    private List<DataParametersAndType> and = null;

    /**
     * @return the dataSetId
     */
    public List<QueryIDType> getDataSetId() {
        return dataSetId;
    }

    /**
     * @param dataSetId the dataSetId to set
     */
    public void setDataSetId(List<QueryIDType> dataSetId) {
        this.dataSetId = dataSetId;
    }

    /**
     * @return the dataProvider
     */
    public List<DataProviderReferenceType> getDataProvider() {
        return dataProvider;
    }

    /**
     * @param dataProvider the dataProvider to set
     */
    public void setDataProvider(List<DataProviderReferenceType> dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * @return the dataStructure
     */
    public List<DataStructureReferenceType> getDataStructure() {
        return dataStructure;
    }

    /**
     * @param dataStructure the dataStructure to set
     */
    public void setDataStructure(List<DataStructureReferenceType> dataStructure) {
        this.dataStructure = dataStructure;
    }

    /**
     * @return the dataflow
     */
    public List<DataflowReferenceType> getDataflow() {
        return dataflow;
    }

    /**
     * @param dataflow the dataflow to set
     */
    public void setDataflow(List<DataflowReferenceType> dataflow) {
        this.dataflow = dataflow;
    }

    /**
     * @return the provisionAgreement
     */
    public List<ProvisionAgreementReferenceType> getProvisionAgreement() {
        return provisionAgreement;
    }

    /**
     * @param provisionAgreement the provisionAgreement to set
     */
    public void setProvisionAgreement(List<ProvisionAgreementReferenceType> provisionAgreement) {
        this.provisionAgreement = provisionAgreement;
    }

    /**
     * @return the category
     */
    public List<CategoryReferenceType> getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(List<CategoryReferenceType> category) {
        this.category = category;
    }

    /**
     * @return the updated
     */
    public List<TimeRangeValueType> getUpdated() {
        return updated;
    }

    /**
     * @param updated the updated to set
     */
    public void setUpdated(List<TimeRangeValueType> updated) {
        this.updated = updated;
    }

    /**
     * @return the conceptValue
     */
    public List<ConceptValueType> getConceptValue() {
        return conceptValue;
    }

    /**
     * @param conceptValue the conceptValue to set
     */
    public void setConceptValue(List<ConceptValueType> conceptValue) {
        this.conceptValue = conceptValue;
    }

    /**
     * @return the representationValue
     */
    public List<CodeValueType> getRepresentationValue() {
        return representationValue;
    }

    /**
     * @param representationValue the representationValue to set
     */
    public void setRepresentationValue(List<CodeValueType> representationValue) {
        this.representationValue = representationValue;
    }

    /**
     * @return the dimensionValue
     */
    public List<DimensionValueType> getDimensionValue() {
        return dimensionValue;
    }

    /**
     * @param dimensionValue the dimensionValue to set
     */
    public void setDimensionValue(List<DimensionValueType> dimensionValue) {
        this.dimensionValue = dimensionValue;
    }

    /**
     * @return the timeDimensionValue
     */
    public List<TimeDimensionValueType> getTimeDimensionValue() {
        return timeDimensionValue;
    }

    /**
     * @param timeDimensionValue the timeDimensionValue to set
     */
    public void setTimeDimensionValue(List<TimeDimensionValueType> timeDimensionValue) {
        this.timeDimensionValue = timeDimensionValue;
    }

    /**
     * @return the attributeValue
     */
    public List<AttributeValueType> getAttributeValue() {
        return attributeValue;
    }

    /**
     * @param attributeValue the attributeValue to set
     */
    public void setAttributeValue(List<AttributeValueType> attributeValue) {
        this.attributeValue = attributeValue;
    }

    /**
     * @return the primaryMeasureValue
     */
    public List<PrimaryMeasureValueType> getPrimaryMeasureValue() {
        return primaryMeasureValue;
    }

    /**
     * @param primaryMeasureValue the primaryMeasureValue to set
     */
    public void setPrimaryMeasureValue(List<PrimaryMeasureValueType> primaryMeasureValue) {
        this.primaryMeasureValue = primaryMeasureValue;
    }

    /**
     * @return the attachmentConstraint
     */
    public List<AttachmentConstraintReferenceType> getAttachmentConstraint() {
        return attachmentConstraint;
    }

    /**
     * @param attachmentConstraint the attachmentConstraint to set
     */
    public void setAttachmentConstraint(List<AttachmentConstraintReferenceType> attachmentConstraint) {
        this.attachmentConstraint = attachmentConstraint;
    }

    /**
     * @return the timeFormat
     */
    public List<TimeDataType> getTimeFormat() {
        return timeFormat;
    }

    /**
     * @param timeFormat the timeFormat to set
     */
    public void setTimeFormat(List<TimeDataType> timeFormat) {
        this.timeFormat = timeFormat;
    }

    /**
     * @return the or
     */
    public List<DataParametersOrType> getOr() {
        return or;
    }

    /**
     * @param or the or to set
     */
    public void setOr(List<DataParametersOrType> or) {
        this.or = or;
    }

    /**
     * @return the and
     */
    public List<DataParametersAndType> getAnd() {
        return and;
    }

    /**
     * @param and the and to set
     */
    public void setAnd(List<DataParametersAndType> and) {
        this.and = and;
    }
    

}
