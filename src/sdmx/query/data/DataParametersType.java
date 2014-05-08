/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.common.TimeDataType;
import sdmx.common.TimeRangeValueType;
import sdmx.commonreferences.CategoryReferenceType;
import sdmx.commonreferences.DataProviderReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.DataflowReferenceType;
import sdmx.commonreferences.ProvisionAgreementReferenceType;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSet;
import sdmx.query.base.CodeValueType;
import sdmx.query.base.QueryIDType;

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
public class DataParametersType  {
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
     public boolean match(ColumnMapper mapper,DataSet set,int row) {
       for(int i=0;attributeValue!=null&&i<attributeValue.size();i++) {
           Object value = set.getValue(row, mapper.getColumnIndex(attributeValue.get(i).getId().toString()));
           if( value instanceof String ) {
               if( !attributeValue.get(i).match((String) value)) return false;
           }
           if( value instanceof CodeValueType ) {
               if( !attributeValue.get(i).match(((CodeValueType)value).getValue())) return false;
           }
        }
        for(int i=0;dimensionValue!=null&&i<this.dimensionValue.size();i++) {
           Object value = set.getValue(row, mapper.getColumnIndex(dimensionValue.get(i).getId().toString()));
           if( value instanceof String ) {
               if( !dimensionValue.get(i).match((String) value)) return false;
           }
           if( value instanceof CodeValueType ) {
               if( !dimensionValue.get(i).match(((CodeValueType)value).getValue())) return false;
           }
        }
        for(int i=0;primaryMeasureValue!=null&&i<this.primaryMeasureValue.size();i++) {
           Object value = set.getValue(row, mapper.getColumnIndex(primaryMeasureValue.get(i).getId().toString()));
           if( value instanceof String ) {
               if( !primaryMeasureValue.get(i).match((String) value)) return false;
           }
           if( value instanceof CodeValueType ) {
               if( !primaryMeasureValue.get(i).match(((CodeValueType)value).getValue())) return false;
           }
        }
        for(int i=0;timeDimensionValue!=null&&i<this.timeDimensionValue.size();i++) {
           Object value = set.getValue(row, mapper.getColumnIndex(timeDimensionValue.get(i).getId().toString()));
           if( value instanceof String ) {
               if( !timeDimensionValue.get(i).match((String) value)) return false;
           }
           if( value instanceof CodeValueType ) {
               if( !timeDimensionValue.get(i).match(((CodeValueType)value).getValue())) return false;
           }
        }
        System.out.println("Matched!");
        return true;
    }   
    public List<String> getDimensionParameters(String concept) {
        if( dimensionValue==null)return Collections.EMPTY_LIST;
        List<String> result = new ArrayList<String>();
        for(int i=0;i<this.dimensionValue.size();i++) {
            if( dimensionValue.get(i).getId().equals(concept))result.add(dimensionValue.get(i).getValue());
        }
        return result;
    }
}
