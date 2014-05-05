/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.commonreferences.ProvisionAgreementReferenceType;
import sdmx.commonreferences.StructureReferenceBaseType;
import sdmx.commonreferences.StructureUsageReferenceBaseType;
import sdmx.xml.ID;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="PayloadStructureType" abstract="true">
		<xs:annotation>
			<xs:documentation>PayloadStructureType is an abstract base type used to define the structural information for data or metadata sets. A reference to the structure is provided (either explicitly or through a reference to a structure usage).</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:choice>
				<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType">
					<xs:annotation>
						<xs:documentation>ProvisionAgreement references a provision agreement which the data or metadata is reported against.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="StructureUsage" type="StructureUsageReferenceBaseType">
					<xs:annotation>
						<xs:documentation>StructureUsage references a flow which the data or metadata is reported against.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="Structure" type="StructureReferenceBaseType">
					<xs:annotation>
						<xs:documentation>Structure references the structure which defines the structure of the data or metadata set.</xs:documentation>
					</xs:annotation>
				</xs:element>
			</xs:choice>
		</xs:sequence>
		<xs:attribute name="structureID" type="xs:ID" use="required">
			<xs:annotation>
				<xs:documentation>The structureID attribute uniquely identifies the structure for the purpose of referencing it from the payload. This is only used in structure specific formats. Although it is required, it is only useful when more than one data set is present in the message.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="schemaURL" type="xs:anyURI" use="optional">
			<xs:annotation>
				<xs:documentation>The schemaURL attribute provides a location from which the structure specific schema can be located.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="namespace" type="xs:anyURI" use="optional">
			<xs:annotation>
				<xs:documentation>The namespace attribute is used to provide the namespace for structure-specific formats. By communicating this information in the header, it is possible to generate the structure specific schema while processing the message.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="optional">
			<xs:annotation>
				<xs:documentation>The dimensionAtObservation is used to reference the dimension at the observation level for data messages. This can also be given the explicit value of "AllDimensions" which denotes that the cross sectional data is in the flat format.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="explicitMeasures" type="xs:boolean" use="optional">
			<xs:annotation>
				<xs:documentation>The explicitMeasures indicates whether explicit measures are used in the cross sectional format. This is only applicable for the measure dimension as the dimension at the observation level or the flat structure.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attributeGroup ref="ExternalReferenceAttributeGroup"/>
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
public class PayloadStructureType {
    private ID structureID = null;
    private anyURI schemaURL = null;
    private anyURI namespace = null;
    private ObservationDimensionType dimensionAtObservation = null;
    private boolean explicitMeasures = false;
    private anyURI serviceURL;
    private anyURI structureURL;

    // Choice of 1
    private ProvisionAgreementReferenceType provisionAgreement;
    private StructureUsageReferenceBaseType structureUsage;
    private StructureReferenceBaseType structure;
    


    public PayloadStructureType(ID struct,anyURI schema,anyURI namespace,ObservationDimensionType dim,boolean explicit,anyURI serviceURL,anyURI structureURL){
        this.structureID=struct;
        this.schemaURL=schema;
        this.namespace=namespace;
        this.dimensionAtObservation=dim;
        this.explicitMeasures=explicit;
        this.serviceURL=serviceURL;
        this.structureURL=structureURL;
    }
    public PayloadStructureType() {
    }

    /**
     * @return the structureID
     */
    public ID getStructureID() {
        return structureID;
    }

    /**
     * @return the dimensionAtObservation
     */
    public ObservationDimensionType getDimensionAtObservation() {
        return dimensionAtObservation;
    }

    /**
     * @return the explicitMeasures
     */
    public boolean isExplicitMeasures() {
        return explicitMeasures;
    }

    /**
     * @return the provisionAgreement
     */
    public ProvisionAgreementReferenceType getProvisionAgreement() {
        return provisionAgreement;
    }

    /**
     * @param provisionAgreement the provisionAgreement to set
     */
    public void setProvisionAgreement(ProvisionAgreementReferenceType provisionAgreement) {
        this.provisionAgreement = provisionAgreement;
    }

    /**
     * @return the structureUsage
     */
    public StructureUsageReferenceBaseType getStructureUsage() {
        return structureUsage;
    }

    /**
     * @param structureUsage the structureUsage to set
     */
    public void setStructureUsage(StructureUsageReferenceBaseType structureUsage) {
        this.structureUsage = structureUsage;
    }

    /**
     * @return the structure
     */
    public StructureReferenceBaseType getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(StructureReferenceBaseType structure) {
        this.structure = structure;
    }

    /**
     * @param structureID the structureID to set
     */
    public void setStructureID(ID structureID) {
        this.structureID = structureID;
    }

    /**
     * @param dimensionAtObservation the dimensionAtObservation to set
     */
    public void setDimensionAtObservation(ObservationDimensionType dimensionAtObservation) {
        this.dimensionAtObservation = dimensionAtObservation;
    }

    /**
     * @param explicitMeasures the explicitMeasures to set
     */
    public void setExplicitMeasures(boolean explicitMeasures) {
        this.explicitMeasures = explicitMeasures;
    }

    /**
     * @return the serviceURL
     */
    public anyURI getServiceURL() {
        return serviceURL;
    }

    /**
     * @param serviceURL the serviceURL to set
     */
    public void setServiceURL(anyURI serviceURL) {
        this.serviceURL = serviceURL;
    }

    /**
     * @return the structureURL
     */
    public anyURI getStructureURL() {
        return structureURL;
    }

    /**
     * @param structureURL the structureURL to set
     */
    public void setStructureURL(anyURI structureURL) {
        this.structureURL = structureURL;
    }

    /**
     * @return the schemaURL
     */
    public anyURI getSchemaURL() {
        return schemaURL;
    }

    /**
     * @param schemaURL the schemaURL to set
     */
    public void setSchemaURL(anyURI schemaURL) {
        this.schemaURL = schemaURL;
    }

    /**
     * @return the namespace
     */
    public anyURI getNamespace() {
        return namespace;
    }

    /**
     * @param namespace the namespace to set
     */
    public void setNamespace(anyURI namespace) {
        this.namespace = namespace;
    }

}
