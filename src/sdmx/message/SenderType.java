/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.common.TimezoneType;

/**
 *	<xs:complexType name="SenderType">
		<xs:annotation>
			<xs:documentation>SenderType extends the basic party structure to add an optional time zone declaration.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="PartyType">
				<xs:sequence>
					<xs:element name="Timezone" type="common:TimezoneType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Timezone specifies the time zone of the sender, and if specified can be applied to all un-time zoned time values in the message. In the absence of this, any dates without time zone are implied to be in an indeterminate "local time".</xs:documentation>
						</xs:annotation>
					</xs:element>					
				</xs:sequence>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

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
public class SenderType extends PartyType {
    private TimezoneType Timezone;

    /**
     * @return the Timezone
     */
    public TimezoneType getTimezone() {
        return Timezone;
    }

    /**
     * @param Timezone the Timezone to set
     */
    public void setTimezone(TimezoneType Timezone) {
        this.Timezone = Timezone;
    }
}
