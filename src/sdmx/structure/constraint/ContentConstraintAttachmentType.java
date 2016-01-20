/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import java.util.List;
import sdmx.commonreferences.ProvisionAgreementReference;
import sdmx.common.QueryableDataSourceType;
import sdmx.commonreferences.DataProviderReference;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.MetadataStructureReference;
import sdmx.commonreferences.MetadataflowReference;
import sdmx.commonreferences.SetReference;
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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class ContentConstraintAttachmentType extends ConstraintAttachmentType {
  
  
}
