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

import sdmx.common.CodedStatusMessageType;

/**
 *	<xs:complexType name="FooterMessageType">
		<xs:annotation>
			<xs:documentation>FooterMessageType defines the structure of a message that is contained in the footer of a message. It is a status message that have a severity code of Error, Information, or Warning added to it.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="common:CodedStatusMessageType">
				<xs:attribute name="severity" type="SeverityCodeType" use="optional"/>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */

public class FooterMessageType extends CodedStatusMessageType {
    private SeverityCodeType severity;

    /**
     * @return the severity
     */
    public SeverityCodeType getSeverity() {
        return severity;
    }

    /**
     * @param severity the severity to set
     */
    public void setSeverity(SeverityCodeType severity) {
        this.severity = severity;
    }
}
