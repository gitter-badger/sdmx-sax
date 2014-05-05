/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.CubeRegionKeyTypeChoice;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;
import sdmx.common.choice.TimeRangeValueTypeChoice;

/**
 *	<xs:complexType name="TimeRangeValueType">
		<xs:annotation>
			<xs:documentation>TimeRangeValueType allows a time period value to be expressed as a range. It can be expressed as the period before a period, after a period, or between two periods. Each of these properties can specify their inclusion in regards to the range.</xs:documentation>
		</xs:annotation>
		<xs:choice>
			<xs:element name="BeforePeriod" type="TimePeriodRangeType">
				<xs:annotation>
					<xs:documentation>BeforePeriod is the period before which the period is meant to cover. This date may be inclusive or exclusive in the range.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="AfterPeriod" type="TimePeriodRangeType">
				<xs:annotation>
					<xs:documentation>AfterPeriod is the period after which the period is meant to cover. This date may be inclusive or exclusive in the range.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:sequence>
				<xs:element name="StartPeriod" type="TimePeriodRangeType">
					<xs:annotation>
						<xs:documentation>StartPeriod is the start date or the range that the queried date must occur within. This date may be inclusive or exclusive in the range.</xs:documentation>
					</xs:annotation>
				</xs:element>
				<xs:element name="EndPeriod" type="TimePeriodRangeType">
					<xs:annotation>
						<xs:documentation>EndPeriod is the end period of the range. This date may be inclusive or exclusive in the range.</xs:documentation>
					</xs:annotation>
				</xs:element>
			</xs:sequence>
		</xs:choice>
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
public class TimeRangeValueType implements ComponentValueSetTypeChoice,CubeRegionKeyTypeChoice,MetadataTargetRegionKeyTypeChoice {
    TimeRangeValueTypeChoice choice = null;
    public TimeRangeValueType(TimeRangeValueTypeChoice choice) {
        this.choice=choice;
    }
}
