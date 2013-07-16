/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

/**
 *	<xs:complexType name="ReportPeriodTargetType">
		<xs:annotation>
			<xs:documentation>ReportPeriodTargetType defines the structure of a report period target object. The report period target object has a fixed representation and identifier.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="TargetObject">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element name="LocalRepresentation" type="ReportPeriodRepresentationType"/>
				</xs:sequence>
				<xs:attribute name="id" type="common:NCNameIDType" use="optional" fixed="REPORT_PERIOD_TARGET"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ReportPeriodTargetType extends TargetObject {

    public ReportPeriodRepresentationType getLocalRepresentation() {
        return (ReportPeriodRepresentationType)super.getLocalRepresentation();
    }
}
