/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.CubeRegionType;
import sdmx.common.MetadataTargetRegionType;
import sdmx.common.QueryableDataSourceType;

/**
 *	<xs:complexType name="ConstraintType" abstract="true">
		<xs:annotation>
			<xs:documentation>ConstraintType is an abstract base type that specific types of constraints (content and attachment) restrict and extend to describe their details. The inclusion of a key or region in a constraint is determined by first processing the included key sets, and then removing those keys defined in the excluded key sets. If no included key sets are defined, then it is assumed the all possible keys or regions are included, and any excluded key or regions are removed from this complete set.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="ConstraintBaseType">
				<xs:sequence>
					<xs:element name="ConstraintAttachment" type="ConstraintAttachmentType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ConstraintAttachment describes the collection of constrainable artefacts that the constraint is attached to.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:choice minOccurs="0" maxOccurs="unbounded">
						<xs:element name="DataKeySet" type="DataKeySetType">
							<xs:annotation>
								<xs:documentation></xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="MetadataKeySet" type="MetadataKeySetType">
							<xs:annotation>
								<xs:documentation></xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="CubeRegion" type="common:CubeRegionType">
							<xs:annotation>
								<xs:documentation></xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="MetadataTargetRegion" type="common:MetadataTargetRegionType">
							<xs:annotation>
								<xs:documentation></xs:documentation>
							</xs:annotation>
						</xs:element>
					</xs:choice>
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
public class ConstraintType extends ConstraintBaseType {
    
    private ConstraintAttachmentType constraintAttachment=null;
    
// Choice of 1    
    private List<DataKeySetType> dataKeySet = null;
    private List<MetadataKeySetType> metaDataKeySet = null;
    private List<CubeRegionType> cubeRegion = null;
    private List<MetadataTargetRegionType> metadataTargetRegion = null;

    /**
     * @return the constraintAttachment
     */
    public ConstraintAttachmentType getConstraintAttachment() {
        return constraintAttachment;
    }

    /**
     * @param constraintAttachment the constraintAttachment to set
     */
    public void setConstraintAttachment(ConstraintAttachmentType constraintAttachment) {
        this.constraintAttachment = constraintAttachment;
    }

    /**
     * @return the dataKeySet
     */
    public List<DataKeySetType> getDataKeySet() {
        return dataKeySet;
    }

    /**
     * @param dataKeySet the dataKeySet to set
     */
    public void setDataKeySet(List<DataKeySetType> dataKeySet) {
        this.dataKeySet = dataKeySet;
    }

    /**
     * @return the metaDataKeySet
     */
    public List<MetadataKeySetType> getMetaDataKeySet() {
        return metaDataKeySet;
    }

    /**
     * @param metaDataKeySet the metaDataKeySet to set
     */
    public void setMetaDataKeySet(List<MetadataKeySetType> metaDataKeySet) {
        this.metaDataKeySet = metaDataKeySet;
    }

    /**
     * @return the cubeRegion
     */
    public List<CubeRegionType> getCubeRegion() {
        return cubeRegion;
    }

    /**
     * @param cubeRegion the cubeRegion to set
     */
    public void setCubeRegion(List<CubeRegionType> cubeRegion) {
        this.cubeRegion = cubeRegion;
    }

    /**
     * @return the metadataTargetRegion
     */
    public List<MetadataTargetRegionType> getMetadataTargetRegion() {
        return metadataTargetRegion;
    }

    /**
     * @param metadataTargetRegion the metadataTargetRegion to set
     */
    public void setMetadataTargetRegion(List<MetadataTargetRegionType> metadataTargetRegion) {
        this.metadataTargetRegion = metadataTargetRegion;
    }
    
}
