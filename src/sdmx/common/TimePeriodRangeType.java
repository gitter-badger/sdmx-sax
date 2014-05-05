/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

/**
 *	<xs:complexType name="TimePeriodRangeType">
		<xs:annotation>
			<xs:documentation>TimePeriodRangeType defines a time period, and indicates whether it is inclusive in a range.</xs:documentation>
		</xs:annotation>
		<xs:simpleContent>
			<xs:extension base="ObservationalTimePeriodType">
				<xs:attribute name="isInclusive" type="xs:boolean" default="true">
					<xs:annotation>
						<xs:documentation>The isInclusive attribute, when true, indicates that the time period specified is included in the range.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:simpleContent>
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
public class TimePeriodRangeType extends ObservationalTimePeriodType {

    private boolean isInclusive = true;
    
    public TimePeriodRangeType(String s) {
        super(s);
        this.isInclusive=true;
    }
    public TimePeriodRangeType(String s,boolean inc) {
        super(s);
        this.isInclusive=inc;
    }
}
