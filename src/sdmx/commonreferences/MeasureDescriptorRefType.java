/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentListTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *<xs:complexType name="MeasureDescriptorRefType">
		<xs:annotation>
			<xs:documentation>MeasureDescriptorRefType contains a reference to the measure descriptor within a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentListRefBaseType">
				<xs:attribute name="id" type="IDType" use="required" fixed="MEASURE_DESCRIPTOR"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional" fixed="MeasureDescriptor"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MeasureDescriptorRefType extends ComponentListRefBaseType {
    public MeasureDescriptorRefType(IDType id){
        super(null,null,null,id,ComponentListTypeCodelistType.MEASUREDESCRIPTOR,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
}
