/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalPrimaryMeasureRefType">
		<xs:annotation>
			<xs:documentation>LocalPrimaryMeasureRefType contains the reference fields for referencing a primary measure locally.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentRefBaseType">
				<xs:attribute name="id" type="IDType" use="required" fixed="OBS_VALUE"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="PrimaryMeasure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalPrimaryMeasureRefType extends LocalComponentRefBaseType {
    public LocalPrimaryMeasureRefType(IDType id){
        super(null,id,ComponentTypeCodelistType.PRIMARYMEASURE,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
}
