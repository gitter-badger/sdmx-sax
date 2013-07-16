/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.common.choice.ComponentValueSetTypeChoice;
import sdmx.common.choice.DistinctKeyValueTypeChoice;
import sdmx.common.choice.MetadataKeyValueTypeChoice;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;
import sdmx.commonreferences.DataProviderReferenceType;
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
public class SetReferenceType implements ComponentValueSetTypeChoice,DistinctKeyValueTypeChoice,MetadataKeyValueTypeChoice,MetadataTargetRegionKeyTypeChoice {
    DataProviderReferenceType ref;
    IDType id;
    public SetReferenceType(DataProviderReferenceType ref, IDType id){
        this.ref=ref;
        this.id=id;
    }
}
