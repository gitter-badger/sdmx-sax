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
package sdmx.footer;

/**
 *	<xs:complexType name="FooterType">
		<xs:annotation>
			<xs:documentation>FooterType describes the structure of a message footer. The footer is used to convey any error, information, or warning messages. This is to be used when the message has payload, but also needs to communicate additional information. If an error occurs and no payload is generated, an Error message should be returned.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Message" type="FooterMessageType" maxOccurs="unbounded">
				<xs:annotation>
					<xs:documentation>Message contains a single error, information, or warning message. A code is provided along with an optional severity. The text of the message can be expressed in multiple languages.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
	</xs:complexType>

 * @author James
 */

public class FooterType {
    private FooterMessageType message;

    /**
     * @return the message
     */
    public FooterMessageType getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(FooterMessageType message) {
        this.message = message;
    }
}
