/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import java.util.List;
import sdmx.metadata.MetadataSetType;

/**
 *	<xs:complexType name="GenericMetadataType">
		<xs:annotation>
			<xs:documentation>GenericMetadataType defines the contents of a generic metadata message.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MessageType">
				<xs:sequence>
					<xs:element name="Header" type="GenericMetadataHeaderType"/>
					<xs:element name="MetadataSet" type="metadata:MetadataSetType" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element ref="footer:Footer" minOccurs="0"/>
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
public class MetadataMessage {
    private List<MetadataSetType> metadataSet;

    /**
     * @return the metadataSet
     */
    public List<MetadataSetType> getMetadataSet() {
        return metadataSet;
    }

    /**
     * @param metadataSet the metadataSet to set
     */
    public void setMetadataSet(List<MetadataSetType> metadataSet) {
        this.metadataSet = metadataSet;
    }

}
