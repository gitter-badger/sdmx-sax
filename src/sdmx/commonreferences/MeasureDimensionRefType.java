/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.DimensionTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="MeasureDimensionRefType">
		<xs:annotation>
			<xs:documentation>MeasureDimensionRefType contains a reference to the measure dimension within a data structure definition. Note that since there is only one key descriptor, the container reference fields are prohibited.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="prohibited"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="DimensionTypeCodelistType" use="optional" fixed="MeasureDimension"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class MeasureDimensionRefType extends ComponentRefBaseType {
      public MeasureDimensionRefType(IDType id){
          super(null,null,null,null,id,DimensionTypeCodelistType.MEASUREDIMENSION,StructurePackageTypeCodelistType.DATASTRUCTURE);
      }
}
