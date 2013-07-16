/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *		<xs:complexType name="StructureSpecificMetadataStructureType">
		<xs:annotation>
			<xs:documentation>StructureSpecificMetadataStructureType defines the structural information for a structured metadata message.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MetadataStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="MetadataflowReferenceType"/>
						<xs:element name="Structure" type="MetadataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="namespace" type="xs:anyURI" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureSpecificMetadataStructureType extends MetadataStructureType {
    private MetadataflowReferenceType structureUsage = null;
    private MetadataStructureReferenceType structure = null;
    public StructureSpecificMetadataStructureType(anyURI namespace){
        super(namespace);
    }

    /**
     * @return the structureUsage
     */
    public MetadataflowReferenceType getStructureUsage() {
        return structureUsage;
    }

    /**
     * @param structureUsage the structureUsage to set
     */
    public void setStructureUsage(MetadataflowReferenceType structureUsage) {
        this.structureUsage = structureUsage;
    }

    /**
     * @return the structure
     */
    public MetadataStructureReferenceType getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(MetadataStructureReferenceType structure) {
        this.structure = structure;
    }

}
