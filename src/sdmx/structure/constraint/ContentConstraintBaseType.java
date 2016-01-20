/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

/**
 *	<xs:complexType name="ContentConstraintBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ContentConstraintBaseType is an abstract base type that forms the basis for the ContentConstraintType.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ConstraintType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="ConstraintAttachment" type="ContentConstraintAttachmentType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ConstraintAttachment describes the collection of constrainable artefacts that the constraint is attached to.</xs:documentation>
						</xs:annotation>
					</xs:element>
1					<xs:choice minOccurs="0" maxOccurs="unbounded">
						<xs:element name="DataKeySet" type="DataKeySetType">
							<xs:annotation>
								<xs:documentation>DataKeySet defines a collection of full or partial data keys.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="MetadataKeySet" type="MetadataKeySetType">
							<xs:annotation>
								<xs:documentation>MetadataKeySet defines a collection of metadata keys.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="CubeRegion" type="common:CubeRegionType">
							<xs:annotation>
								<xs:documentation>CubeRegion describes a set of dimension values which define a region and attributes which relate to the region for the purpose of describing a constraint.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="MetadataTargetRegion" type="common:MetadataTargetRegionType">
							<xs:annotation>
								<xs:documentation>MetadataTargetRegion describes a set of target object values for a given report structure which define a region, and the metadata attribute which relate to the target for the purpose of describing a constraint.</xs:documentation>
							</xs:annotation>
						</xs:element>
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
public class ContentConstraintBaseType extends ConstraintType {
    
}
