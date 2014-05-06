/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

/**
 *	<xs:complexType name="GenericMetadataHeaderType">
		<xs:annotation>
			<xs:documentation>GenericMetadataHeaderType defines the header format for generic reference metadata.</xs:documentation>
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
					<xs:element name="Structure" type="common:GenericMetadataStructureType" maxOccurs="unbounded"/>
					<xs:element name="DataProvider" type="common:DataProviderReferenceType" minOccurs="0"/>
					<xs:element name="DataSetAction" type="common:ActionType" minOccurs="0"/>
					<xs:element name="DataSetID" type="common:IDType" minOccurs="0" maxOccurs="unbounded"/>	
					<xs:element name="Extracted" type="xs:dateTime" minOccurs="0"/>
					<xs:element name="Source" type="common:TextType" minOccurs="0" maxOccurs="unbounded"/>					
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class GenericMetadataHeaderType extends BaseHeaderType {
    
}
