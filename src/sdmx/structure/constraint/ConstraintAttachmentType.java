/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import java.util.List;
import sdmx.common.QueryableDataSourceType;
import sdmx.commonreferences.DataProviderReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.DataflowReferenceType;
import sdmx.commonreferences.MetadataStructureReferenceType;
import sdmx.commonreferences.MetadataflowReferenceType;
import sdmx.commonreferences.ProvisionAgreementReferenceType;
import sdmx.commonreferences.SetReferenceType;
import sdmx.structure.base.MaintainableType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ConstraintAttachmentType" abstract="true">
		<xs:annotation>
			<xs:documentation>ConstraintAttachmentType describes a collection of references to constrainable artefacts.</xs:documentation>
		</xs:annotation>
		<xs:choice>
			<xs:element name="DataProvider" type="common:DataProviderReferenceType">
				<xs:annotation>
					<xs:documentation>DataProvider is reference to a data provider to which the constraint is attached. If this is used, then only the release calendar is relevant. The referenced is provided as a URN and/or a full set of reference fields.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="DataSet" type="common:SetReferenceType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>DataSet is reference to a data set to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="MetadataSet" type="common:SetReferenceType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>MetadataSet is reference to a metadata set to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="SimpleDataSource" type="xs:anyURI" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>SimpleDataSource describes a simple data source, which is a URL of a SDMX-ML data or metadata message.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:choice>
				<xs:sequence>
					<xs:element name="DataStructure" type="common:DataStructureReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>DataStructure is reference to a data structure definition to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. A constraint which is attached to more than one data structure must only express key sets and/or cube regions where the identifiers of the dimensions are common across all structures to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>QueryableDataSource describes a queryable data source to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:sequence>
					<xs:element name="MetadataStructure" type="common:MetadataStructureReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>MetadataStructure is reference to a metadata structure definition to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. A constraint which is attached to more than one metadata structure must only express key sets and/or target regions where the identifiers of the target objects are common across all structures to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>QueryableDataSource describes a queryable data source to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:sequence>
					<xs:element name="Dataflow" type="common:DataflowReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>Dataflow is reference to a data flow to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. A constraint can be attached to more than one dataflow, and the dataflows do not necessarily have to be usages of the same data structure. However, a constraint which is attached to more than one data structure must only express key sets and/or cube regions where the identifiers of the dimensions are common across all structures to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>QueryableDataSource describes a queryable data source to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:sequence>
					<xs:element name="Metadataflow" type="common:MetadataflowReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>Metadataflow is reference to a metadata flow to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. A constraint can be attached to more than one metadataflow, and the metadataflows do not necessarily have to be usages of the same metadata structure. However, a constraint which is attached to more than one metadata structure must only express key sets and/or target regions where the identifiers of the target objects are common across all structures to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>QueryableDataSource describes a queryable data source to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>					
				</xs:sequence>
				<xs:sequence>
					<xs:element name="ProvisionAgreement" type="common:ProvisionAgreementReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>ProvisionAgreementReference is reference to a provision agreement to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. A constraint can be attached to more than one provision aggreement, and the provision agreements do not necessarily have to be references structure usages based on the same structure. However, a constraint which is attached to more than one provision agreement must only express key sets and/or cube/target regions where the identifier of the components are common across all structures to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>QueryableDataSource describes a queryable data source to which the constraint is attached.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:choice>
		</xs:choice>
	</xs:complexType>

 * @author James
 */
public abstract class ConstraintAttachmentType extends MaintainableType {
    private DataProviderReferenceType dataProvider = null;
    private List<SetReferenceType> dataSets=null;
    private List<SetReferenceType> metadataSets=null;
    private List<anyURI> simpleDataSources =null;

    // or 1 of these and a queryable datasource
   private List<DataStructureReferenceType> dataStructures=null;
   private List<MetadataStructureReferenceType> metadataStructures = null;
   private List<DataflowReferenceType> dataFlows = null;
   private List<MetadataflowReferenceType> metadataFlows = null;
   private List<ProvisionAgreementReferenceType> provisionAgreement = null;
   private QueryableDataSourceType queryableDataSource= null;

    /**
     * @return the dataProvider
     */
    public DataProviderReferenceType getDataProvider() {
        return dataProvider;
    }

    /**
     * @param dataProvider the dataProvider to set
     */
    public void setDataProvider(DataProviderReferenceType dataProvider) {
        this.dataProvider = dataProvider;
    }

    /**
     * @return the dataStructures
     */
    public List<DataStructureReferenceType> getDataStructures() {
        return dataStructures;
    }

    /**
     * @param dataStructures the dataStructures to set
     */
    public void setDataStructures(List<DataStructureReferenceType> dataStructures) {
        this.dataStructures = dataStructures;
    }

    /**
     * @return the metadataStructures
     */
    public List<MetadataStructureReferenceType> getMetadataStructures() {
        return metadataStructures;
    }

    /**
     * @param metadataStructures the metadataStructures to set
     */
    public void setMetadataStructures(List<MetadataStructureReferenceType> metadataStructures) {
        this.metadataStructures = metadataStructures;
    }

    /**
     * @return the dataFlows
     */
    public List<DataflowReferenceType> getDataflows() {
        return dataFlows;
    }

    /**
     * @param dataFlows the dataFlows to set
     */
    public void setDataflows(List<DataflowReferenceType> dataFlows) {
        this.dataFlows = dataFlows;
    }

    /**
     * @return the metadataFlows
     */
    public List<MetadataflowReferenceType> getMetadataFlows() {
        return metadataFlows;
    }

    /**
     * @param metadataFlows the metadataFlows to set
     */
    public void setMetadataFlows(List<MetadataflowReferenceType> metadataFlows) {
        this.metadataFlows = metadataFlows;
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
     * @return the queryableDataSource
     */
    public QueryableDataSourceType getQueryableDataSource() {
        return queryableDataSource;
    }

    /**
     * @param queryableDataSource the queryableDataSource to set
     */
    public void setQueryableDataSource(QueryableDataSourceType queryableDataSource) {
        this.queryableDataSource = queryableDataSource;
    }

    /**
     * @return the dataSets
     */
    public List<SetReferenceType> getDataSets() {
        return dataSets;
    }

    /**
     * @param dataSets the dataSets to set
     */
    public void setDataSets(List<SetReferenceType> dataSets) {
        this.dataSets = dataSets;
    }

    /**
     * @return the metadataSets
     */
    public List<SetReferenceType> getMetadataSets() {
        return metadataSets;
    }

    /**
     * @param metadataSets the metadataSets to set
     */
    public void setMetadataSets(List<SetReferenceType> metadataSets) {
        this.metadataSets = metadataSets;
    }

    /**
     * @return the simpleDataSources
     */
    public List<anyURI> getSimpleDataSources() {
        return simpleDataSources;
    }

    /**
     * @param simpleDataSources the simpleDataSources to set
     */
    public void setSimpleDataSources(List<anyURI> simpleDataSources) {
        this.simpleDataSources = simpleDataSources;
    }
}