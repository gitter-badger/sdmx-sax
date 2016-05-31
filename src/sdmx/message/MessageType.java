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
package sdmx.message;

import sdmx.footer.FooterType;

/**
 *	<xs:complexType name="MessageType" abstract="true">
		<xs:annotation>
			<xs:documentation>MessageType is an abstract type which is used by all of the messages, to allow inheritance of common features. Every message consists of a mandatory header, followed by optional payload (which may occur multiple times), and finally an optional footer section for conveying error, warning, and informational messages.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="Header" type="BaseHeaderType"/>
			<xs:any namespace="##targetNamespace" minOccurs="0" maxOccurs="unbounded"/>
			<xs:element ref="footer:Footer" minOccurs="0"/>
		</xs:sequence>
	</xs:complexType>	

 * @author James
 */

public abstract class MessageType {
    private BaseHeaderType header;
    private FooterType footer;

    /**
     * @return the header
     */
    public BaseHeaderType getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(BaseHeaderType header) {
        this.header = header;
    }

    /**
     * @return the footer
     */
    public FooterType getFooter() {
        return footer;
    }

    /**
     * @param footer the footer to set
     */
    public void setFooter(FooterType footer) {
        this.footer = footer;
    }
}
