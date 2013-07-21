/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureSpecificDataStructureType">
		<xs:annotation>
			<xs:documentation>StructureSpecificDataStructureType defines the structural information for a structured data set. In addition to referencing the data structure or dataflow which defines the structure of the data, the namespace for the data structure specific schema as well as which dimension is used at the observation level must be provided. It is also necessary to state whether the format uses explicit measures, although this is technically only applicable is the dimension at the observation level is the measure dimension or the flat data format is used.</xs:documentation>
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
				<xs:attribute name="namespace" type="xs:anyURI" use="required"/>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required"/>
				<xs:attribute name="explicitMeasures" type="xs:boolean" default="false"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureSpecificDataStructureType extends DataStructureType {
    URI namespace = null;
    ObservationDimensionType dimensionAtObservation = null;
    boolean explicitMeasures = false;
    public StructureSpecificDataStructureType(anyURI namespace,ObservationDimensionType dim,boolean explicitMeasures){
        // No ID?
        super(null,null,namespace,dim,explicitMeasures,null,null);
    }
}