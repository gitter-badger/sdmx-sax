/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="LocalComponentRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalComponentRefBaseType is an abstract base type which provides a local reference to a component object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="prohibited"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentRefBaseType extends LocalComponentListComponentRefBaseType {
       public LocalComponentRefBaseType(NestedIDType containId,NestedIDType id, ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
           super(containId,id,obs,pack);
       }
}
