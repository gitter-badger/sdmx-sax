/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.structure.base.StructureType;

/**
 *	<xs:complexType name="MetadataStructureType">
		<xs:annotation>
			<xs:documentation>MetadataStructureType is used to describe a metadata structure definition, which is defined as a collection of metadata concepts, their structure and usage when used to collect or disseminate reference metadata.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:sequence minOccurs="0">
						<xs:element ref="MetadataStructureComponents"/>
					</xs:sequence>
				</xs:sequence>
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
public class MetadataStructureType extends StructureType {
    private List<MetadataTargetType> targets = null;
    private List<ReportStructure> reports = null;
    
    
    
    public MetadataStructureType() {
       super();
    }    

    /**
     * @return the targets
     */
    public List<MetadataTargetType> getTargets() {
        return targets;
    }

    /**
     * @param targets the targets to set
     */
    public void setTargets(List<MetadataTargetType> targets) {
        this.targets = targets;
    }

    /**
     * @return the reports
     */
    public List<ReportStructure> getReports() {
        return reports;
    }

    /**
     * @param reports the reports to set
     */
    public void setReports(List<ReportStructure> reports) {
        this.reports = reports;
    }

}
