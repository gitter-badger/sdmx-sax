/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import sdmx.common.QueryableDataSourceType;

/**
 *	<xs:complexType name="AttachmentConstraintAttachmentType">
		<xs:annotation>
			<xs:documentation>AttachmentConstraintAttachmentType defines the structure for specifying the object to which an attachment constraints applies.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ConstraintAttachmentType">
				<xs:choice>
					<xs:element name="DataSet" type="common:SetReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>DataSet is reference to a data set to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. Multiple instance can only be used if they have the same underlying structure.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="MetadataSet" type="common:SetReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>MetadataSet is reference to a metadata set to which the constraint is attached. The referenced is provided as a URN and/or a full set of reference fields. Multiple instance can only be used if they have the same underlying structure.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="SimpleDataSource" type="xs:anyURI" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>SimpleDataSource describes a simple data source, which is a URL of a SDMX-ML data or metadata message. Multiple instance can only be used if they have the same underlying structure.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:choice>
						<xs:element name="DataStructure" type="common:DataStructureReferenceType" maxOccurs="unbounded"/>
						<xs:element name="MetadataStructure" type="common:MetadataStructureReferenceType" maxOccurs="unbounded"/>
						<xs:element name="Dataflow" type="common:DataflowReferenceType" maxOccurs="unbounded"/>
						<xs:element name="Metadataflow" type="common:MetadataflowReferenceType" maxOccurs="unbounded"/>
						<xs:element name="ProvisionAgreement" type="common:ProvisionAgreementReferenceType" maxOccurs="unbounded"/>
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
public class AttachmentConstraintAttachmentType extends ConstraintAttachmentType {



}
