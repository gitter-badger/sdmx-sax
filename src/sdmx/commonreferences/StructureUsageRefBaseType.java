/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="StructureUsageRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>StructureUsageRefBaseType is an abstract base type for referencing a structure usage.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureOrUsageRefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="optional" default="1.0"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="StructureUsageTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class StructureUsageRefBaseType extends StructureOrUsageRefBaseType {
   public StructureUsageRefBaseType(NestedNCNameIDType agencyID,IDType id,VersionType vers,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(agencyID,id,vers,obs,pack);
   }
}
