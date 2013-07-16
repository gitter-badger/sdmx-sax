/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
