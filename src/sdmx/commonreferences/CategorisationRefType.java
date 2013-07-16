/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="CategorisationRefType">
		<xs:annotation>
			<xs:documentation>CategorisationRefType provides a reference to a categorisation via a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="Categorisation"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
class CategorisationRefType extends MaintainableRefType {
   public CategorisationRefType(MaintainableTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(obs,pack);
   }
}
