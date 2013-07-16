/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:complexType name="TimeSeriesGenericDataStructureRequestType">
		<xs:annotation>
			<xs:documentation>TimeSeriesGenericDataStructureRequestType is a variation of a the GenericDataStructureRequestType for querying purposes. The observation dimension is fixed to TIME_PERIOD.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="GenericDataStructureRequestType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="DataflowReferenceType"/>
						<xs:element name="Structure" type="DataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required" fixed="TIME_PERIOD"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class TimeSeriesGenericDataStructureRequestType extends GenericDataStructureRequestType {
    private static final ObservationDimensionType dimensionAtObservation = new ObservationDimensionType("TIME_PERIOD");
    public TimeSeriesGenericDataStructureRequestType(boolean explicit){
        super(dimensionAtObservation,explicit);
        // No ID?
    }

}
