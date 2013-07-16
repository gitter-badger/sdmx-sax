/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="HierarchicalCodeRefType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodeRefType references a code from within a hierarchical codelist. Reference fields are required for both the code and the codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the hierarchical codelist in which the code being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the hierarchical codelist in which the code being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="containerID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The containerID references the hierarchy which contains the code being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="HierarchicalCode"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class HierarchicalCodeRefType extends ContainerChildObjectRefBaseType {
    public HierarchicalCodeRefType(IDType maintainableParentID,VersionType maintainableParentVersion,IDType containerID) {
        super((NestedNCNameIDType)null,maintainableParentID,maintainableParentVersion,null,containerID,ObjectTypeCodelistType.HIERARCHICALCODE,PackageTypeCodelistType.CODELIST);
    }
}
