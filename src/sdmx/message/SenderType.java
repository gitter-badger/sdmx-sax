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
