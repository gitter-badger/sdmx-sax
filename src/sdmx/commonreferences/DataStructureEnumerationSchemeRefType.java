/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.DimensionEnumerationTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;

/**
 *	<xs:complexType name="DataStructureEnumerationSchemeRefType">
		<xs:annotation>
			<xs:documentation>DataStructureEnumerationSchemeRefType contains the reference fields for referencing any item scheme that is allowable as the enumeration of the representation of a data structure definition component.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeRefType">
				<xs:attribute name="class" type="DimensionEumerationSchemeTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataStructureEnumerationSchemeRefType extends ItemSchemeRefType {

    public DataStructureEnumerationSchemeRefType(DimensionEnumerationTypeCodelistType clazz,ItemSchemePackageTypeCodelistType pack){
        super(clazz,pack);
    }
    
}
