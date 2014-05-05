/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.commonreferences.IDType;
import java.util.List;

/**
 *	<xs:complexType name="MetadataTargetRegionType">
		<xs:annotation>
			<xs:documentation>MetadataTargetRegionType defines the structure of a metadata target region. A metadata target region must define the report structure and the metadata target from that structure on which the region is based. This type is based on the abstract RegionType and simply refines the key and attribute values to conform with what is applicable for target objects and metadata attributes, respectively. See the documentation of the base type for more details on how a region is defined.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RegionType">
				<xs:sequence>
					<xs:element name="KeyValue" type="MetadataTargetRegionKeyType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="Attribute" type="MetadataAttributeValueSetType" minOccurs="0" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="report" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The report attribute is required and holds the identifier of the report structure which the reference metadata being defined by this region is based on.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="metadataTarget" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The metadataTarget attribute is required and identifies the metadata target for the report structure which this region is based upon. Note that a report structure can have multiple metadata targets, so to properly determine the object or objects for which the region applies, the proper metadata target must be identified.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
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
public class MetadataTargetRegionType extends RegionType {
    private List<MetadataTargetRegionKeyType> keyValue = null;
    private List<MetadataAttributeValueSetType> attribute = null;
    private IDType report = null;
    private IDType metadataTarget = null;

    public MetadataTargetRegionType(List<MetadataTargetRegionKeyType> values,List<MetadataAttributeValueSetType> attributes,IDType report,IDType target) {
        super(null,null);
        this.keyValue=values;
        this.attribute=attributes;
        this.report=report;
        this.metadataTarget=target;
    }

    /**
     * @return the report
     */
    public IDType getReport() {
        return report;
    }

    /**
     * @param report the report to set
     */
    public void setReport(IDType report) {
        this.report = report;
    }

    /**
     * @return the metadataTarget
     */
    public IDType getMetadataTarget() {
        return metadataTarget;
    }

    /**
     * @param metadataTarget the metadataTarget to set
     */
    public void setMetadataTarget(IDType metadataTarget) {
        this.metadataTarget = metadataTarget;
    }

}
