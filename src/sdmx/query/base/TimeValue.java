/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.common.TimeOperatorType;

/**
 *	<xs:element name="TimeValue" type="TimePeriodValueType">
		<xs:annotation>
			<xs:documentation>TimeValue is used to query for the value of a concept or component based on time parameters. This is typically used when the value needs to be treated explicitly as a time, for example when searching for data after a particular point in time. If only a simple equality check is necessary, the Value element can be used.</xs:documentation>
		</xs:annotation>
	</xs:element>
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
public class TimeValue extends TimePeriodValueType {
    public TimeValue(String s) {
        super(s,TimeOperatorType.EQUAL);
    }
    public TimeValue(String s, TimeOperatorType operator) {
        super(s,operator);
    }
}
