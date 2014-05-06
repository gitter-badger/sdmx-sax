/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.commonreferences.LocalMetadataTargetReferenceType;

/**
 *	<xs:complexType name="ReportStructureType">
		<xs:annotation>
			<xs:documentation>ReportStructureType describes the structure of a report structure. It comprises a set of metadata attributes that can be defined as a hierarchy, and identifies the potential attachment of these attributes to an object by referencing a target identifier.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:extension base="ReportStructureBaseType">
				<xs:sequence>
					<xs:element name="MetadataTarget" type="common:LocalMetadataTargetReferenceType" maxOccurs="unbounded">
						<xs:annotation>
							<xs:documentation>MetadataTarget references a metadata target defined in the metadata structure definition. A report structure can reference multiple metadata targets which allows a report structure to be reused for attaching metadata to different types of targets.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:extension>
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
public class ReportStructureType extends ReportStructureBaseType {
    
    private List<LocalMetadataTargetReferenceType> localMetadataTarget = null;

    /**
     * @return the localMetadataTarget
     */
    public List<LocalMetadataTargetReferenceType> getLocalMetadataTarget() {
        return localMetadataTarget;
    }

    /**
     * @param localMetadataTarget the localMetadataTarget to set
     */
    public void setLocalMetadataTarget(List<LocalMetadataTargetReferenceType> localMetadataTarget) {
        this.localMetadataTarget = localMetadataTarget;
    }
    
}
