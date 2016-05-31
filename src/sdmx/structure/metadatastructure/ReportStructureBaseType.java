/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.structure.base.ComponentListType;

/**
 *	<xs:complexType name="ReportStructureBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ReportStructureBaseType is an abstract base type that serves as the basis for the ReportStructureType.</xs:documentation>
		</xs:annotation>		
		<xs:complexContent>	
			<xs:restriction base="ComponentListType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:sequence maxOccurs="unbounded">
						<xs:element ref="MetadataAttribute"/>
					</xs:sequence>
				</xs:sequence>
				<xs:attribute name="id" type="common:IDType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class ReportStructureBaseType extends ComponentListType {
    private List<MetadataAttribute> attributes = null;

    /**
     * @return the attributes
     */
    public List<MetadataAttribute> getMetadataAttributes() {
        return attributes;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setMetadataAttributes(List<MetadataAttribute> attributes) {
        this.attributes = attributes;
    }
    
}
