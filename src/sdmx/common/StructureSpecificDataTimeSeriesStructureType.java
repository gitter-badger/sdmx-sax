/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.xml.anyURI;


/**
 *		<xs:complexType name="StructureSpecificDataTimeSeriesStructureType">
		<xs:annotation>
			<xs:documentation>StructureSpecificDataTimeSeriesStructureType defines the structural information for a structure definition specific time series data set. The dimension at the observation level is fixed to be TIME_PERIOD.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureSpecificDataStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="DataflowReferenceType"/>
						<xs:element name="Structure" type="DataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="namespace" type="xs:anyURI" use="required"/>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required" fixed="TIME_PERIOD"/>
				<xs:attribute name="explicitMeasures" type="xs:boolean" use="prohibited"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureSpecificDataTimeSeriesStructureType extends DataStructureType {
    URI namespace = null;
    ObservationDimensionType dimensionAtObservation = null;
    public StructureSpecificDataTimeSeriesStructureType(anyURI namespace,ObservationDimensionType dim){
        // No ID?
        super(null,null,namespace,dim,false,null,null);
    }
}
