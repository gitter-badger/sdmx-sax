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
