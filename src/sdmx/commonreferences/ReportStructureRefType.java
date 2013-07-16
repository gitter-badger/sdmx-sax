/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="ReportStructureRefType">
		<xs:annotation>
			<xs:documentation>ReportStructureRefType contains a reference to a report structure within a metadata structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="ReportStructure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>	
	</xs:complexType>

 * @author James
 */
public class ReportStructureRefType extends ComponentListRefBaseType {
    public ReportStructureRefType(IDType id) {
        super(null,null,null,id,ComponentListTypeCodelistType.REPORTSTRUCTURE,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }   
}
