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
