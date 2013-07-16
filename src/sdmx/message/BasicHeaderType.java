/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

/**
 *	<xs:complexType name="BasicHeaderType">
		<xs:annotation>
			<xs:documentation>BasicHeaderType defines the most basic header information used in simple message exchanges.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="BaseHeaderType">
				<xs:sequence>
					<xs:element name="ID" type="common:IDType"/>
					<xs:element name="Test" type="xs:boolean" default="false"/>
					<xs:element name="Prepared" type="HeaderTimeType"/>
					<xs:element name="Sender" type="SenderType"/>
					<xs:element name="Receiver" type="PartyType"/>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class BasicHeaderType extends BaseHeaderType {
    
}
