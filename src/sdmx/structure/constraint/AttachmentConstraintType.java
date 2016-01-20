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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class AttachmentConstraintType extends ConstraintType {
    

}
