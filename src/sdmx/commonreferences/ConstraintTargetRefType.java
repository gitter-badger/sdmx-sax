/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ComponentTypeCodelistType;
import sdmx.commonreferences.types.StructurePackageTypeCodelistType;

/**
 *	<xs:complexType name="ConstraintTargetRefType">
		<xs:annotation>
			<xs:documentation>ConstraintTargetRefType contains a reference to a constraint target within a metadata target of a data structure definition.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ComponentRefBaseType">
				<xs:attribute name="containerID" type="IDType" use="required"/>
				<xs:attribute name="id" type="IDType" use="required" fixed="CONSTRAINT_TARGET"/>
				<xs:attribute name="class" type="ComponentTypeCodelistType" use="optional" fixed="ConstraintTarget"/>
				<xs:attribute name="package" type="StructurePackageTypeCodelistType" use="optional" fixed="metadatastructure"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
	
 * @author James
 */
public class ConstraintTargetRefType extends ComponentRefBaseType {
    public ConstraintTargetRefType(IDType containId,IDType id){
        super(null,null,null,containId,id,ComponentTypeCodelistType.CONSTRAINTARGET,StructurePackageTypeCodelistType.METADATASTRUCTURE);
    }
}
