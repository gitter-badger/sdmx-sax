/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

/**
 *	<xs:complexType name="StructureHeaderType">
		<xs:annotation>
			<xs:documentation>StructureHeaderType defines the structure for structural metadata messages.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="BaseHeaderType">
				<xs:sequence>
					<xs:element name="ID" type="common:IDType"/>
					<xs:element name="Test" type="xs:boolean" default="false"/>
					<xs:element name="Prepared" type="HeaderTimeType"/>
					<xs:element name="Sender" type="SenderType"/>
					<xs:element name="Receiver" type="PartyType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element ref="common:Name" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="Source" type="common:TextType" minOccurs="0" maxOccurs="unbounded"/>					
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class StructureHeaderType extends BaseHeaderType {
    
}
