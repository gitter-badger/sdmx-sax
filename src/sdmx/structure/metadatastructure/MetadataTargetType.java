/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import java.util.List;
import sdmx.common.Annotations;
import sdmx.commonreferences.IDType;

/**
	<xs:complexType name="MetadataTargetType">
		<xs:annotation>
			<xs:documentation></xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MetadataTargetBaseType">
				<xs:choice maxOccurs="unbounded">
					<xs:element ref="KeyDescriptorValuesTarget"/>
					<xs:element ref="DataSetTarget"/>
					<xs:element ref="ConstraintContentTarget"/>
					<xs:element ref="ReportPeriodTarget"/>
					<xs:element ref="IdentifiableObjectTarget"/>
				</xs:choice>
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
public class MetadataTargetType extends MetadataTargetBaseType {
    
    private List<KeyDescriptorValuesTarget> keyDescriptor = null;
    private List<DataSetTarget> dataSetTarget = null;
    private List<ConstraintContentTarget> constraintContentTarget = null;
    private List<ReportPeriodTarget> reportPeriodTarget = null;
    private List<IdentifiableObjectTarget> identifiableObjectTarget = null;

    public MetadataTargetType(Annotations annots, IDType id) {
        super(annots,id);
    }

    /**
     * @return the keyDescriptor
     */
    public List<KeyDescriptorValuesTarget> getKeyDescriptor() {
        return keyDescriptor;
    }

    /**
     * @param keyDescriptor the keyDescriptor to set
     */
    public void setKeyDescriptor(List<KeyDescriptorValuesTarget> keyDescriptor) {
        this.keyDescriptor = keyDescriptor;
    }

    /**
     * @return the dataSetTarget
     */
    public List<DataSetTarget> getDataSetTarget() {
        return dataSetTarget;
    }

    /**
     * @param dataSetTarget the dataSetTarget to set
     */
    public void setDataSetTarget(List<DataSetTarget> dataSetTarget) {
        this.dataSetTarget = dataSetTarget;
    }

    /**
     * @return the constraintContentTarget
     */
    public List<ConstraintContentTarget> getConstraintContentTarget() {
        return constraintContentTarget;
    }

    /**
     * @param constraintContentTarget the constraintContentTarget to set
     */
    public void setConstraintContentTarget(List<ConstraintContentTarget> constraintContentTarget) {
        this.constraintContentTarget = constraintContentTarget;
    }

    /**
     * @return the reportPeriodTarget
     */
    public List<ReportPeriodTarget> getReportPeriodTarget() {
        return reportPeriodTarget;
    }

    /**
     * @param reportPeriodTarget the reportPeriodTarget to set
     */
    public void setReportPeriodTarget(List<ReportPeriodTarget> reportPeriodTarget) {
        this.reportPeriodTarget = reportPeriodTarget;
    }

    /**
     * @return the identifiableObjectTarget
     */
    public List<IdentifiableObjectTarget> getIdentifiableObjectTarget() {
        return identifiableObjectTarget;
    }

    /**
     * @param identifiableObjectTarget the identifiableObjectTarget to set
     */
    public void setIdentifiableObjectTarget(List<IdentifiableObjectTarget> identifiableObjectTarget) {
        this.identifiableObjectTarget = identifiableObjectTarget;
    }
    
}
