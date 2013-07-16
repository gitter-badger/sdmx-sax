/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="GenericMetadataStructureType">
		<xs:annotation>
			<xs:documentation>GenericMetadataStructureType defines the structural information for a generic metadata message.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MetadataStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="MetadataflowReferenceType"/>
						<xs:element name="Structure" type="MetadataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="namespace" type="xs:anyURI" use="prohibited"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class GenericMetadataStructureType extends MetadataStructureType {
    public GenericMetadataStructureType(anyURI namespace){
        super(namespace);
    }
}
