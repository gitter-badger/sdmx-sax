/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.DistinctKeyValueTypeChoice;
import sdmx.common.choice.MetadataKeyValueTypeChoice;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;
import sdmx.commonreferences.DataProviderReference;
import sdmx.commonreferences.IDType;

/**
 *	<xs:complexType name="SetReferenceType">
		<xs:annotation>
			<xs:documentation>SetReferenceType defines the structure of a reference to a data/metadata set. A full reference to a data provider and the identifier for the data set must be provided. Note that this is not derived from the base reference structure since data/metadata sets are not technically identifiable.</xs:documentation>
		</xs:annotation>
		<xs:sequence>
			<xs:element name="DataProvider" type="DataProviderReferenceType">
				<xs:annotation>
					<xs:documentation>DataProvider references a the provider of the data/metadata set. A URN and/or a complete set of reference fields must be provided.</xs:documentation>
				</xs:annotation>
			</xs:element>
			<xs:element name="ID" type="IDType">
				<xs:annotation>
					<xs:documentation>ID contains the identifier of the data/metadata set being referenced.</xs:documentation>
				</xs:annotation>
			</xs:element>
		</xs:sequence>
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
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */

public class SetReference implements ComponentValueSetTypeChoice,DistinctKeyValueTypeChoice,MetadataKeyValueTypeChoice,MetadataTargetRegionKeyTypeChoice {
    DataProviderReference ref;
    IDType id;
    public SetReference(DataProviderReference ref, IDType id){
        this.ref=ref;
        this.id=id;
    }
}
