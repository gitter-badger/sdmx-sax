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
public class TimeSeriesDataStructureRequestType extends DataStructureRequestType {
    private static final ObservationDimensionType dimensionAtObservation = new ObservationDimensionType("TIME_PERIOD");
    boolean explicitMeasures = false;
    public TimeSeriesDataStructureRequestType(boolean explicit){
        super(dimensionAtObservation,explicit);
        // No ID?
    }
}
