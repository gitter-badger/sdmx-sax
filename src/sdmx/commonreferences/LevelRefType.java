/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="LevelRefType">
		<xs:annotation>
			<xs:documentation>LevelRefType references a level from within a hierarchical codelist. Reference fields are required for both the level and the codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="Level"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class LevelRefType extends ChildObjectRefBaseType {
    public LevelRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.LEVEL,PackageTypeCodelistType.CODELIST);
    }
    
}
