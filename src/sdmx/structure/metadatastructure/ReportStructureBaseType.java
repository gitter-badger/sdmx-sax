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
