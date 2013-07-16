/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadatastructure;

import sdmx.structure.base.RepresentationType;
import sdmx.structure.base.TimeTextFormatType;

/**
 *	<xs:complexType name="ReportPeriodRepresentationType">
		<xs:annotation>
			<xs:documentation>ReportPeriodRepresentationType defines the possible local representations of a report period target object. The reprentation must be a time period or a subset of this representation.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RepresentationType">
				<xs:sequence>
					<xs:element name="TextFormat" type="TimeTextFormatType"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ReportPeriodRepresentationType extends RepresentationType {
}
