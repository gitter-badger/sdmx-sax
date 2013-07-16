/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.StructureUsagePackageTypeCodelistType;
import sdmx.commonreferences.types.StructureUsageTypeCodelistType;

/**
 *	<xs:complexType name="DataflowRefType">
		<xs:annotation>
			<xs:documentation>DataflowRefType contains a set of reference fields for a data flow.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageRefBaseType">
				<xs:attribute name="class" type="StructureUsageTypeCodelistType" use="optional" fixed="Dataflow"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataflowRefType extends StructureUsageRefBaseType {
    public DataflowRefType(IDType id) {
        super(null,id,null,StructureUsageTypeCodelistType.DATAFLOW,StructureUsagePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
