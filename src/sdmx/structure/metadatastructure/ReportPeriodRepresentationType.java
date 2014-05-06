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
public class ReportPeriodRepresentationType extends RepresentationType {
}
