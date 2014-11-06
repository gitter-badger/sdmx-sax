/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.commonreferences.StructureReferenceBase;
import sdmx.commonreferences.StructureUsageReferenceBase;
import sdmx.xml.ID;

/**
 *	<xs:complexType name="DataStructureRequestType">
		<xs:annotation>
			<xs:documentation>DataStructureRequestType is a variation of a the DataStructureType for querying purposes. Only the observation dimension and the explicit measures flag are allowed.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DataStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="DataflowReferenceType"/>
						<xs:element name="Structure" type="DataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="schemaURL" type="xs:anyURI" use="prohibited"/>
				<xs:attribute name="namespace" type="xs:anyURI" use="prohibited"/>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required"/>
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
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class DataStructureRequestType extends DataStructureType {
    URI schemaURL = null;
    URI namespace = null;
    ObservationDimensionType dimensionAtObservation = null;
    boolean explicitMeasures = false;
    public DataStructureRequestType(ObservationDimensionType dim,boolean explicit){
        // No ID?
        super(null,null,null,dim,explicit,null,null);
    }

}
