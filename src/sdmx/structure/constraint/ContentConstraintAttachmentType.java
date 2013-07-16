/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import java.util.List;
import sdmx.commonreferences.ProvisionAgreementReferenceType;
import sdmx.common.QueryableDataSourceType;
import sdmx.commonreferences.DataProviderReferenceType;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.MetadataStructureReferenceType;
import sdmx.commonreferences.MetadataflowReferenceType;
import sdmx.commonreferences.SetReferenceType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="ContentConstraintAttachmentType">
		<xs:annotation>
			<xs:documentation>ContentConstraintAttachmentType defines the structure for specifying the target object(s) of a content constraint.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ConstraintAttachmentType">
				<xs:choice>
					<xs:element name="DataProvider" type="common:DataProviderReferenceType"/>
					<xs:element name="DataSet" type="common:SetReferenceType"/>
					<xs:element name="MetadataSet" type="common:SetReferenceType"/>
					<xs:element name="SimpleDataSource" type="xs:anyURI"/>
					<xs:choice>
						<xs:sequence>
							<xs:element name="DataStructure" type="common:DataStructureReferenceType" maxOccurs="unbounded"/>
							<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded"/>
						</xs:sequence>
						<xs:sequence>
							<xs:element name="MetadataStructure" type="common:MetadataStructureReferenceType" maxOccurs="unbounded"/>
							<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded"/>
						</xs:sequence>
						<xs:sequence>
							<xs:element name="Dataflow" type="common:DataflowReferenceType" maxOccurs="unbounded"/>
							<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded"/>
						</xs:sequence>
						<xs:sequence>
							<xs:element name="Metadataflow" type="common:MetadataflowReferenceType" maxOccurs="unbounded"/>
							<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded"/>					
						</xs:sequence>
						<xs:sequence>
							<xs:element name="ProvisionAgreement" type="common:ProvisionAgreementReferenceType" maxOccurs="unbounded"/>
							<xs:element name="QueryableDataSource" type="common:QueryableDataSourceType" minOccurs="0" maxOccurs="unbounded"/>
						</xs:sequence>
					</xs:choice>
				</xs:choice>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ContentConstraintAttachmentType extends ConstraintAttachmentType {
  
  
}
