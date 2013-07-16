/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.util.List;

/**
 *	<xs:complexType name="CodedStatusMessageType">
		<xs:annotation>
			<xs:documentation>CodedStatusMessageType describes the structure of an error or warning message which required a code.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StatusMessageType">
				<xs:sequence>
					<xs:element name="Text" type="TextType" maxOccurs="unbounded"/>
				</xs:sequence>
				<xs:attribute name="code" type="xs:string" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class CodedStatusMessageType extends StatusMessageType {
    public CodedStatusMessageType(List<TextType> texts,String code) {
        super(texts,code);
    }
    public CodedStatusMessageType(){}
}
