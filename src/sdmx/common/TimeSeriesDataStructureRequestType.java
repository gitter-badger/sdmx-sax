/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;


/**
 *	<xs:complexType name="TimeSeriesDataStructureRequestType">
		<xs:annotation>
			<xs:documentation>TimeSeriesDataStructureRequestType is a variation of a the DataStructureRequestType for querying purposes. The observation dimension is fixed to TIME_PERIOD</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DataStructureRequestType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="DataflowReferenceType"/>
						<xs:element name="Structure" type="DataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required" fixed="TIME_PERIOD"/>
				<xs:attribute name="explicitMeasures" type="xs:boolean" use="optional" default="false"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class TimeSeriesDataStructureRequestType extends DataStructureRequestType {
    private static final ObservationDimensionType dimensionAtObservation = new ObservationDimensionType("TIME_PERIOD");
    boolean explicitMeasures = false;
    public TimeSeriesDataStructureRequestType(boolean explicit){
        super(dimensionAtObservation,explicit);
        // No ID?
    }
}
