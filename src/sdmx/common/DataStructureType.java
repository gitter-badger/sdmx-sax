/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common;

import java.net.URI;
import sdmx.common.ExternalReferenceAttributeGroup;
import sdmx.common.ObservationDimensionType;
import sdmx.common.PayloadStructureType;
import sdmx.commonreferences.ProvisionAgreementReferenceType;
import sdmx.xml.ID;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.DataflowReferenceType;
import sdmx.xml.anyURI;
/**
 *	<xs:complexType name="DataStructureType" abstract="true">
		<xs:annotation>
			<xs:documentation>DataStructureType is an abstract base type the forms the basis for the structural information for a data set.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="PayloadStructureType">
				<xs:sequence>
					<xs:choice>
						<xs:element name="ProvisionAgrement" type="ProvisionAgreementReferenceType">
							<xs:annotation>
								<xs:documentation>ProvisionAgreement references a provision agreement which the data is reported against.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="StructureUsage" type="DataflowReferenceType">
							<xs:annotation>
								<xs:documentation>StructureUsage references a dataflow which the data is reported against.</xs:documentation>
							</xs:annotation>
						</xs:element>
						<xs:element name="Structure" type="DataStructureReferenceType">
							<xs:annotation>
								<xs:documentation>Structure references the data structure definition which defines the structure of the data.</xs:documentation>
							</xs:annotation>
						</xs:element>
					</xs:choice>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataStructureType extends PayloadStructureType {
    private ProvisionAgreementReferenceType provisionAgreement = null;
    private DataflowReferenceType structureUsage = null;
    private DataStructureReferenceType structure = null;
    public DataStructureType(ID struct,anyURI schema,anyURI namespace,ObservationDimensionType dim,boolean explicit,anyURI serviceURL, anyURI structureURL){
        super(struct,schema,namespace,dim,explicit,serviceURL,structureURL);
    }

    /**
     * @return the provisionAgreement
     */
    public ProvisionAgreementReferenceType getProvisionAgreement() {
        return provisionAgreement;
    }

    /**
     * @param provisionAgreement the provisionAgreement to set
     */
    public void setProvisionAgreement(ProvisionAgreementReferenceType provisionAgreement) {
        this.provisionAgreement = provisionAgreement;
    }

    /**
     * @return the structureUsage
     */
    public DataflowReferenceType getStructureUsage() {
        return structureUsage;
    }

    /**
     * @param structureUsage the structureUsage to set
     */
    public void setStructureUsage(DataflowReferenceType structureUsage) {
        this.structureUsage = structureUsage;
    }

    /**
     * @return the structure
     */
    public DataStructureReferenceType getStructure() {
        return structure;
    }

    /**
     * @param structure the structure to set
     */
    public void setStructure(DataStructureReferenceType structure) {
        this.structure = structure;
    }
}
