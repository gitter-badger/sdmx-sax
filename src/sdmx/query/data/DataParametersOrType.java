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
 *	<xs:complexType name="DataParametersType" abstract="true">
		<xs:annotation>
			<xs:documentation>DataParametersType defines the parameters for querying for data. This structure is refined by separate And/Or constructs which make logical restrictions on which parameters apply in such cases.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="DataSetID" type="QueryIDType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>DataSetID is used to match the id of the data set. Only data from data sets with an identifier satisfying these conditions will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="DataProvider" type="common:DataProviderReferenceType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>DataProvider is used to match the provider of data to the referenced data provider. Only data from data sets provided by the referenced data provider will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="DataStructure" type="common:DataStructureReferenceType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>DataStructure is used to match the underlying structure of the data. Only data from data sets that conform to referenced data structure definition will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Dataflow" type="common:DataflowReferenceType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Dataflow is used to match the flow which data is reported against. Only data from data sets report against referenced dataflow will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="ProvisionAgreement" type="common:ProvisionAgreementReferenceType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>ProvisionAgreement is used to match the provision agreement which data is reported against. Only data from data sets report against the referenced provision agreement will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Category" type="common:CategoryReferenceType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Category is used to match a data based on the categorization of its underlying structure (data structure definition), or the usage of that structure (data flow). Only data whose underlying structure or structure usage are categorized against the referenced category will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Updated" type="common:TimeRangeValueType" minOccurs="0" maxOccurs="2">
				<xs:annotation>
					<xs:documentation>Updated is used to match data based on when it was last updated (including additions and deletions). Only data which satisfies the conditions for the last update parameters supplied here will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="ConceptValue" type="ConceptValueType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>ConceptValue is used to match data based on the value of a particular concept. This concept may be used as a dimension, attribute, or measure for the data. So long as the referenced concept has the specified value for a given data point, it will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="RepresentationValue" type="CodeValueType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>RepresentationValue is used to match data based on a representation scheme having a particular value. This representation scheme may be used as the representation of a dimension, attribute, or measure. So long as the value of the concept using the referenced codelist has the value specified, any data point for the concept will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="DimensionValue" type="DimensionValueType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>DimensionValue is used to match data based on the value of a dimension. Any data with the dimension with the supplied identifier satisfies the conditions supplied will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="TimeDimensionValue" type="TimeDimensionValueType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>TimeDimensionValue is used to match data based on the value of the time dimension. Any data with a time value satisfying the conditions supplied will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="AttributeValue" type="AttributeValueType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>AttributeValue is used to match data based on the value of an attribute. Any data with an attribute with the supplied identifier satisfies the conditions supplied will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="PrimaryMeasureValue" type="PrimaryMeasureValueType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>PrimaryMeasureValue is used to match data based on the value of the primary measure. Any data with its value satisfying the conditions supplied will be matched.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="AttachmentConstraint" type="common:AttachmentConstraintReferenceType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>AttachmentConstraint references an attachment constraint in order to match data which matches the effective data keys or cube regions defined in the constraint. Data will be returned by first matching data on the keys and cube regions that are marked as included (or all data if none), and then excluding the data that satisfies the conditions of the excluded keys and cube regions.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="TimeFormat" type="common:TimeDataType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>TimeFormat is used to match data when a frequency dimension is not explicitly defined. Only data reported against the supplied time data type will be returned.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="Or" type="DataParametersOrType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Or contains a collection of additional parameters, any one of which can be satisfied to result in a match.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="And" type="DataParametersAndType" minOccurs="0" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>And contains a collection of additional parameters, all of which must be satisfied to result in a match.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>

 * @author James
 */
public class DataParametersOrType {
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