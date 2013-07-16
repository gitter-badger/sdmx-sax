/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="ReportPeriodTargetRefType">
		<xs:annotation>
			<xs:documentation>ReportPeriodTargetRefType contains a reference to a report period target within a metadata target of a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required" fixed="REPORT_PERIOD_TARGET"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="ReportPeriodTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ReportPeriodTargetRefType extends ComponentRefBaseType{
    public ReportPeriodTargetRefType(IDType containId,IDType id){
        super(null,null,null,containId,id,ComponentTypeCodelistType.REPORTINGPERIODTARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
