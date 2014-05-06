/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.xml.DateTime;
import sdmx.xml.DateType;

/**
 *	<xs:simpleType name="HeaderTimeType">
		<xs:annotation>
			<xs:documentation>Provides a union type of xs:date and xs:dateTime for the header fields in the message.</xs:documentation>
		</xs:annotation>
		<xs:union memberTypes="xs:dateTime xs:date"/>
	</xs:simpleType>

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
public class HeaderTimeType {

    private DateTime date;

    public HeaderTimeType() {
        
    }

    /**
     * @return the date
     */
    public DateTime getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(DateTime date) {
        this.date = date;
    }
}
