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
