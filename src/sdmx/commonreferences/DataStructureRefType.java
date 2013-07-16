/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.StructureTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="DataStructureRefType">
		<xs:annotation>
			<xs:documentation>DataStructureRefType contains a set of reference fields for a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="StructureRefBaseType">
				<xs:attribute name="class" type="StructureTypeCodelistType" use="optional" fixed="DataStructure"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="datastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class DataStructureRefType extends StructureRefBaseType {
    public DataStructureRefType(NestedNCNameIDType agency,IDType id,VersionType ver) {
        super(agency,id,ver,StructureTypeCodelistType.DATASTRUCTURE,StructurePackageTypeCodelistType.DATASTRUCTURE);
    }

}
