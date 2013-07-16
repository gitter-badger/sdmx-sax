/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;


/**
 *	<xs:complexType name="GenericDataStructureRequestType">
		<xs:annotation>
			<xs:documentation>GenericDataStructureRequestType is a variation of a the DataStructureRequestType for querying purposes. The explicit measure flag in not allowed.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="DataStructureRequestType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType"/>
						<xs:element name="StructureUsage" type="DataflowReferenceType"/>
						<xs:element name="Structure" type="DataStructureReferenceType"/>
					</xs:choice>
				</xs:sequence>
				<xs:attribute name="dimensionAtObservation" type="ObservationDimensionType" use="required"/>
				<xs:attribute name="explicitMeasures" type="xs:boolean" use="prohibited"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class GenericDataStructureRequestType extends DataStructureRequestType {
    ObservationDimensionType dimensionAtObservation = null;
    boolean explicitMeasures = false;
    public GenericDataStructureRequestType(ObservationDimensionType dim,boolean explicit){
        super(dim,explicit);
        // No ID?
        
    }
}
