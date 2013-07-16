/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.StructureOrUsageCodelistType;

/**
 *	<xs:complexType name="StructureOrUsageRefType">
		<xs:annotation>
			<xs:documentation>StructureOrUsageRefType is a type for referencing a structure or structure usage.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureOrUsageRefBaseType">
				<xs:attribute name="class" type="StructureOrUsageTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureOrUsageRefType extends StructureOrUsageRefBaseType {
   public StructureOrUsageRefType(StructureOrUsageCodelistType obs,StructurePackageTypeCodelistType pack) {
       super(null,null,null,obs,pack);
   }
}
