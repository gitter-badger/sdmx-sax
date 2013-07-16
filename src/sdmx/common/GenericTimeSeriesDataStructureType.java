/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;

/**
 *	<xs:complexType name="GenericTimeSeriesDataStructureType">
		<xs:annotation>
			<xs:documentation>GenericTimeSeriesDataStructureType defines the structural information for a generic time series based data set. The dimension at the observation level is fixed to be TIME_PERIOD.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="GenericDataStructureType">
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
public class GenericTimeSeriesDataStructureType extends GenericDataStructureType {
    URI schemaURL = null;
    URI namespace = null;
    ObservationDimensionType dimensionAtObservation = null;
    public GenericTimeSeriesDataStructureType(ObservationDimensionType dim){
        // No ID?
        super(null,null,dim);
    }
}
