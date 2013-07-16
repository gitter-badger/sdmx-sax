/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="LocalComponentListComponentRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalComponentRefBaseType is an abstract base type which provides a local reference to a component object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentListComponentRefBaseType extends LocalIdentifiableRefBaseType {
       public LocalComponentListComponentRefBaseType(NestedIDType containId,NestedIDType id, ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
           super(containId,id,obs,pack);
       }
}
