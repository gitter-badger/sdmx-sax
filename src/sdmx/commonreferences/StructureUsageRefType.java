/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="StructureUsageRefType">
		<xs:annotation>
			<xs:documentation>StructureUsageRefType contains a set of reference fields for referencing any structure usage.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureUsageRefBaseType">
				<xs:attribute name="class" type="StructureUsageTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureUsageRefType extends StructureUsageRefBaseType {
   public StructureUsageRefType(ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(null,null,null,obs,pack);
   }
}
