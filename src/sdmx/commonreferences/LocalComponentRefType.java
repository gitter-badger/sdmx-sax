/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.ComponentListTypeCodelistType;

/**
 *	<xs:complexType name="LocalComponentRefType">
		<xs:annotation>
			<xs:documentation>LocalComponentRefType provides a local reference to any type component object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentRefBaseType">
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentRefType extends LocalComponentRefBaseType {
       public LocalComponentRefType(NestedIDType containId,NestedIDType id,ComponentListTypeCodelistType obs,StructurePackageTypeCodelistType pack) {
           super(containId,id,obs,pack);
       }
}
