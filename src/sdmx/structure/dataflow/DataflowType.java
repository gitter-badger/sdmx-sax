/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.dataflow;

import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.structure.base.StructureUsageType;

/**
 *	<xs:complexType name="DataflowType">
		<xs:annotation>
			<xs:documentation>DataflowType describes the structure of a data flow. A data flow is defined as the structure of data that will provided for different reference periods. If this type is not referenced externally, then a reference to a key family definition must be provided.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageType">
				<xs:sequence>
					<xs:element ref="common:Annotations" minOccurs="0"/>
					<xs:element ref="common:Name" maxOccurs="unbounded"/>
					<xs:element ref="common:Description" minOccurs="0" maxOccurs="unbounded"/>
					<xs:element name="Structure" type="common:DataStructureReferenceType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Structure provides a reference to the data structure definition which defines the structure of all data for this flow.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:restriction>
		</xs:complexContent>		
	</xs:complexType>
 * @author James
 */
public class DataflowType extends StructureUsageType {
    @Override
    public DataStructureReferenceType getStructure() {
        return (DataStructureReferenceType)super.getStructure();
    }

    public void dump() {
    }
}
