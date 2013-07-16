/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ObjectTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="ConceptSchemeMapRefType">
		<xs:annotation>
			<xs:documentation>ConceptSchemeMapRefType contains a set of reference fields for a concept scheme map.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ChildObjectRefBaseType">
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="optional" fixed="ConceptSchemeMap"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="mapping"/>					
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>	

 * @author James
 */
public class ConceptSchemeMapRefType extends ChildObjectRefBaseType {
    public ConceptSchemeMapRefType(IDType id){
        super(null,null,null,id,ObjectTypeCodelistType.CONCEPTSCHEMEMAP,PackageTypeCodelistType.MAPPING);
    }
}
