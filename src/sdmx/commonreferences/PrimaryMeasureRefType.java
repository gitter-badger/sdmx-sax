/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="PrimaryMeasureRefType">
		<xs:annotation>
			<xs:documentation>PrimaryMeasureRefType contains a reference to the primary measure within a data structure definition. Note that since there is only one key descriptor, the container reference fields are prohibited.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="prohibited"/>
				<xs:attribute name="id" type="IDType" use="required" fixed="OBS_VALUE"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="PrimaryMeasure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class PrimaryMeasureRefType extends ComponentRefBaseType {

    public PrimaryMeasureRefType(IDType id){
        super(null,null,null,null,id,ComponentTypeCodelistType.PRIMARYMEASURE,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }

}
