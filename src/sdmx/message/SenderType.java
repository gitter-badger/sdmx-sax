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
