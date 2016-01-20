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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class TimeValue extends TimePeriodValueType {
    public TimeValue(String s) {
        super(s,TimeOperatorType.EQUAL);
    }
    public TimeValue(String s, TimeOperatorType operator) {
        super(s,operator);
    }
}
