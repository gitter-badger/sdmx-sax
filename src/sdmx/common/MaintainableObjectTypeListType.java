/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.common;

import sdmx.commonreferences.ObjectTypeList;

/**
 *	<xs:complexType name="MaintainableObjectTypeListType">
		<xs:annotation>
			<xs:documentation>MaintainableObjectTypeListType provides a means for enumerating maintainable object types.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ObjectTypeListType">
				<xs:all>
					<xs:element ref="AgencyScheme" minOccurs="0"/>
					<xs:element ref="AttachmentConstraint" minOccurs="0"/>
					<xs:element ref="Categorisation" minOccurs="0"/>
					<xs:element ref="CategoryScheme" minOccurs="0"/>
					<xs:element ref="Codelist" minOccurs="0"/>
					<xs:element ref="ConceptScheme" minOccurs="0"/>
					<xs:element ref="ContentConstraint" minOccurs="0"/>
					<xs:element ref="Dataflow" minOccurs="0"/>
					<xs:element ref="DataConsumerScheme" minOccurs="0"/>
					<xs:element ref="DataProviderScheme" minOccurs="0"/>
					<xs:element ref="DataStructure" minOccurs="0"/>
					<xs:element ref="HierarchicalCodelist" minOccurs="0"/>
					<xs:element ref="Metadataflow" minOccurs="0"/>
					<xs:element ref="MetadataStructure" minOccurs="0"/>
					<xs:element ref="OrganisationUnitScheme" minOccurs="0"/>
					<xs:element ref="Process" minOccurs="0"/>
					<xs:element ref="ProvisionAgreement" minOccurs="0"/>
					<xs:element ref="ReportingTaxonomy" minOccurs="0"/>
					<xs:element ref="StructureSet" minOccurs="0"/>
				</xs:all>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class MaintainableObjectTypeListType extends ObjectTypeList {
    
}
