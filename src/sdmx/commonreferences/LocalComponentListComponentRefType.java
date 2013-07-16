/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.ComponentTypeCodelistType;

/**
 *	<xs:complexType name="LocalComponentListComponentRefType">
		<xs:annotation>
			<xs:documentation>LocalComponentListComponentRefType provides a local reference to any component object within a specific component list. References for both of these are required as well as an indication of which type of type of component is being referenced via the class attribute.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="NestedIDType" use="required"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="true"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentListComponentRefType extends LocalComponentListComponentRefBaseType {
       public LocalComponentListComponentRefType(NestedIDType containerID,NestedIDType id,ComponentTypeCodelistType ob,StructurePackageTypeCodelistType pack) {
           super(containerID,id,ob,pack);
       }
}
