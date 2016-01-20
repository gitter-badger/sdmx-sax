/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.commonreferences.LocalMetadataTargetReference;

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
public class ReportStructureType extends ReportStructureBaseType {
    
    private List<LocalMetadataTargetReference> localMetadataTarget = null;

    /**
     * @return the localMetadataTarget
     */
    public List<LocalMetadataTargetReference> getLocalMetadataTarget() {
        return localMetadataTarget;
    }

    /**
     * @param localMetadataTarget the localMetadataTarget to set
     */
    public void setLocalMetadataTarget(List<LocalMetadataTargetReference> localMetadataTarget) {
        this.localMetadataTarget = localMetadataTarget;
    }
    
}
