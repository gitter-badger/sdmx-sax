/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalReportStructureRefType">
		<xs:annotation>
			<xs:documentation>LocalReportStructureRefType contains a local reference to a report structure object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListRefBaseType">
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="ReportStructure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalReportStructureRefType extends LocalComponentListRefBaseType {
    public LocalReportStructureRefType(IDType id){
        super(id,ComponentListTypeCodelistType.REPORTSTRUCTURE,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
