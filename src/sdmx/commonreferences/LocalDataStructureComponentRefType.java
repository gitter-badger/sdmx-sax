/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.DataStructureComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="LocalDataStructureComponentRefType">
		<xs:annotation>
			<xs:documentation>LocalDataStructureComponentRefType contains the reference fields for referencing any data structure component locally. This reference must specify the class of the component being referenced.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalComponentListComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="prohibited"/>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="DataStructureComponentTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LocalDataStructureComponentRefType extends LocalComponentListComponentRefBaseType {
    public LocalDataStructureComponentRefType(IDType id,DataStructureComponentTypeCodelistType clazz){
        super(null,id,clazz,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }
    
}
