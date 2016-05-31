/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.common;

import sdmx.xml.DateTime;

/**
 *	<xs:complexType name="ReferencePeriodType">
		<xs:annotation>
			<xs:documentation>Specifies the inclusive start and end times.</xs:documentation>
		</xs:annotation>
		<xs:attribute name="startTime" type="xs:dateTime" use="required">
			<xs:annotation>
				<xs:documentation>The startTime attributes contains the inclusive start date for the reference period.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
		<xs:attribute name="endTime" type="xs:dateTime" use="required">
			<xs:annotation>
				<xs:documentation>The endTime attributes contains the inclusive end date for the reference period.</xs:documentation>
			</xs:annotation>
		</xs:attribute>
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
public class ReferencePeriodType {
    private DateTime startTime = null;
    private DateTime endTime = null;
    public ReferencePeriodType(DateTime start,DateTime end) {
        startTime =start;
        endTime=end;
    }

    /**
     * @return the startTime
     */
    public DateTime getStartTime() {
        return startTime;
    }

    /**
     * @return the endTime
     */
    public DateTime getEndTime() {
        return endTime;
    }

}
