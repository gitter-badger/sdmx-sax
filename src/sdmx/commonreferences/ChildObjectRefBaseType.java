/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="ChildObjectRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ChildObjectRefBaseType is an abstract base type for referencing any child object defined directly within a maintainable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="maintainableParentID" type="IDType" use="required"/>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0"/>
				<xs:attribute name="containerID" type="NestedIDType" use="prohibited"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="prohibited"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ChildObjectRefBaseType extends RefBaseType {
      public ChildObjectRefBaseType(NestedNCNameIDType agencyID,IDType mainParent,VersionType pvers,NestedIDType id,ObjectTypeCodelistType obs, PackageTypeCodelistType pack){ 
          super(agencyID,id,null,mainParent,pvers,null,false,obs,pack);
      }
}
