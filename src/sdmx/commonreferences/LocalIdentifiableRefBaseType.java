/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="LocalIdentifiableRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalIdentifiableRefBaseType is an abstract base type which provides a local reference to any identifiable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="prohibited"/>
				<xs:attribute name="maintainableParentID" type="IDType" use="prohibited"/>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="prohibited"/>
				<xs:attribute name="containerID" type="NestedIDType" use="optional"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="version" type="VersionType" use="prohibited"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="true"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalIdentifiableRefBaseType extends RefBaseType {
       public LocalIdentifiableRefBaseType(NestedIDType containId,NestedIDType id, ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
           super(null,id,null,null,null,containId,true,obs,pack);
       }
}
