/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="DataSetTargetRefType">
		<xs:annotation>
			<xs:documentation>DataSetTargetRefType contains a reference to a data set target within a metadata target of a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required" fixed="DATA_SET_TARGET"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="DataSetTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataSetTargetRefType extends ComponentRefBaseType {
    public DataSetTargetRefType(IDType containId,IDType id){
        super(null,null,null,containId,id,ComponentTypeCodelistType.DATASETTARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
    
}
