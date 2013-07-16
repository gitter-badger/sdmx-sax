/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="StructureRefType">
		<xs:annotation>
			<xs:documentation>StructureRefType contains a set of reference fields for referencing any structure.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureRefBaseType">
				<xs:attribute name="class" type="StructureTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureRefType extends StructureRefBaseType {
   public StructureRefType(ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(null,null,null,obs,pack);
   }

}
