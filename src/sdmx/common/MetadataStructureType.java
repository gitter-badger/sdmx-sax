/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="MetadataStructureType" abstract="true">
		<xs:annotation>
			<xs:documentation>MetadataStructureType is an abstract base type the forms the basis of the structural information for any metadata message. A reference to the metadata structure definition or a metadataflow must be provided. This can be used to determine the structure of the message.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="PayloadStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType">
							<xs:annotation>
								<xs:documentation>ProvisionAgreement references a provision agreement which the metadata is reported against.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="StructureUsage" type="MetadataflowReferenceType">
							<xs:annotation>
								<xs:documentation>StructureUsage references a metadataflow which the metadata is reported against.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="Structure" type="MetadataStructureReferenceType">
							<xs:annotation>
								<xs:documentation>Structure references the metadata structure definition which defines the structure of the metadata.</xs:documentation>
							</xs:annotation>
						</xs:element>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="prohibited"/>
				<xs:attribute name="explicitMeasures" type="xs:boolean" use="prohibited"/>
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
public class MetadataStructureType extends PayloadStructureType {
    
    
    public MetadataStructureType(){
        super();
    }
    // Used by StructureSpecificMetadataStructureType
    // this class does not have a namespcae attribute!
    public MetadataStructureType(anyURI namespace){
        super.setNamespace(namespace);
    }

    /**
     * @return the structureUsage
     */
    @Override
    public MetadataflowReferenceType getStructureUsage() {
        return (MetadataflowReferenceType)super.getStructureUsage();
    }

    /**
     * @param structureUsage the structureUsage to set
     */
    public void setStructureUsage(MetadataflowReferenceType structureUsage) {
        super.setStructureUsage(structureUsage);
    }

    /**
     * @return the structure
     */
    public MetadataStructureReferenceType getStructure() {
        return (MetadataStructureReferenceType) super.getStructure();
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(MetadataStructureReferenceType structure) {
        super.setStructure(structure);
    }
    
}
