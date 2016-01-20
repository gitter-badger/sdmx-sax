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
