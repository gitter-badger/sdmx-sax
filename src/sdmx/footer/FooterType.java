/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
