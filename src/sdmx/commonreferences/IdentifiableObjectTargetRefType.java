/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="IdentifiableObjectTargetRefType">
		<xs:annotation>
			<xs:documentation>IdentifiableObjectTargetRefType contains a reference to an identifiable object target within a metadata target of a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="IdentifiableObjectTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class IdentifiableObjectTargetRefType extends ComponentRefBaseType {
    public IdentifiableObjectTargetRefType(IDType id){
        super(null,null,null,null,id,ComponentTypeCodelistType.IDENTIFIABLEOBJECTTARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
