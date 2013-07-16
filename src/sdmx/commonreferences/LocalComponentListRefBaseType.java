/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.commonreferences.types.ComponentListTypeCodelistType;

/**
 *	<xs:complexType name="LocalComponentListRefBaseType" abstract="true">
		<xs:annotation>
			<xs:documentation>LocalComponentListRefBaseType is an abstract base type which provides a local reference to a component list object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalIdentifiableRefBaseType">
				<xs:attribute name="containerID" type="NestedIDType" use="prohibited"/>
				<xs:attribute name="class" type="ComponentListTypeCodelistType" use="optional"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalComponentListRefBaseType extends LocalIdentifiableRefBaseType {
    public LocalComponentListRefBaseType(IDType id,ComponentListTypeCodelistType obs, StructurePackageTypeCodelistType pack){
        super(null,id,obs,pack);
    }
}
