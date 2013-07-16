/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.ComponentTypeCodelistType;

/**
 *	<xs:complexType name="ComponentRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>ComponentRefBaseType is an abstract base type for referencing a component contained in a component list within a structure.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ContainerChildObjectRefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the structure in which the component being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the structure in which the component being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="containerID" type="NestedIDType" use="optional">
					<xs:annotation>
						<xs:documentation>The containerID attribute references the component list of that contains the component being referenced. It is optional for the cases where the component list has a fixed identifier. Specific implementations of this will prohibit or require this accordingly.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ComponentRefBaseType extends ContainerChildObjectRefBaseType {
    public ComponentRefBaseType(NestedNCNameIDType agencyID,IDType mparent,VersionType pvers,NestedIDType contID, NestedIDType id,ComponentTypeCodelistType obs, StructurePackageTypeCodelistType pack) {
        super(agencyID,mparent,pvers,contID,id,obs,pack);
    }
}
