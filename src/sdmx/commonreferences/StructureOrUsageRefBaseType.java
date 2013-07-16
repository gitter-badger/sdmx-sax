/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="StructureOrUsageRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureOrUsageRefBaseType is an abstract base type for referencing a structure or structure usage.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="optional" default="1.0"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="StructureOrUsageTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureOrUsageRefBaseType extends MaintainableRefBaseType {
   public StructureOrUsageRefBaseType(NestedNCNameIDType agencyId,IDType id,VersionType vers,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(agencyId,id,vers,obs,pack);
   }
}
