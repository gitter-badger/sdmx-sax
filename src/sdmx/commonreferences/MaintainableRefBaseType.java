/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="MaintainableRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>MaintainableRefBaseType is an abstract base type for referencing a maintainable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="maintainableParentID" type="IDType" use="prohibited"/>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="prohibited"/>
				<xs:attribute name="containerID" type="NestedIDType" use="prohibited"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="optional" default="1.0"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MaintainableRefBaseType extends RefBaseType {
   public MaintainableRefBaseType(NestedNCNameIDType agencyId,IDType id,VersionType vers,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(agencyId,id,vers,null,null,null,false,obs,pack);
   }
}
