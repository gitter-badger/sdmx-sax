/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.DimensionTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalDimensionRefType">
		<xs:annotation>
			<xs:documentation>LocalDimensionRefType contains the reference fields for referencing a dimension locally.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="DimensionTypeCodelistType" use="optional" default="Dimension">
					<xs:annotation>
						<xs:documentation>The class attribute is optional and provided a default value of Dimension. It is strongly recommended that if the time or measure dimension is referenced, that the proper value be set for this field. However, this is not absolutely necessary since all data structure definition components must have a unique identifier within the scope of the entire data structure. It does, however, allow systems which will treat such a reference as a URN to easily construct the URN without having to verify the object class of the referenced dimension.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalDimensionRefType extends LocalComponentRefBaseType {
    public LocalDimensionRefType(IDType id){
        super(null,id,DimensionTypeCodelistType.DIMENSION,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
