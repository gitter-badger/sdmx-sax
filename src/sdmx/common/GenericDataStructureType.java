/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="GenericDataStructureType">
		<xs:annotation>
			<xs:documentation>GenericDataStructureType defines the structural information for a generic data set. A reference to the structure, either explicitly or through a dataflow or provision agreement is required as well as the dimension which occurs at the observation level.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DataStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="DataflowReferenceType"/>
						<xs:element name="Structure" type="DataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="schemaURL" type="xs:anyURI" use="prohibited"/>
				<xs:attribute name="namespace" type="xs:anyURI" use="prohibited"/>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required"/>
				<xs:attribute name="explicitMeasures" type="xs:boolean" use="prohibited"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class GenericDataStructureType extends DataStructureType {
    URI schemaURL = null;
    URI namespace = null;
    ObservationDimensionType dimensionAtObservation = null;
    public GenericDataStructureType(anyURI schemaURL,anyURI namespace,ObservationDimensionType dim){
        // No ID?
        super(null,schemaURL,namespace,dim,false,null,null);
    }
}
