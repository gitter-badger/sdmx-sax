/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

/**
 *	<xs:complexType name="AttachmentConstraintType">
		<xs:annotation>
			<xs:documentation>AttachmentConstraintType describes the details of an attachment constraint by defining the data or metadata key sets or component regions that attributes or reference metadata may be attached in the constraint attachment objects.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ConstraintType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="ConstraintAttachment" type="AttachmentConstraintAttachmentType" minOccurs="0"/>
					<xs:choice minOccurs="0" maxOccurs="unbounded">
						<xs:element name="DataKeySet" type="DataKeySetType"/>
						<xs:element name="MetadataKeySet" type="MetadataKeySetType"/>
					</xs:choice>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AttachmentConstraintType extends ConstraintType {
    

}
