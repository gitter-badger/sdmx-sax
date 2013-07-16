/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;

/**
 *	<xs:complexType name="ConceptSchemeRefType">
		<xs:annotation>
			<xs:documentation>ConceptSchemeRefType provides a reference to a concept scheme via a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeRefBaseType">
				<xs:attribute name="class" type="ItemSchemeTypeCodelistType" use="optional" fixed="ConceptScheme"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="conceptscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ConceptSchemeRefType extends ItemSchemeRefBaseType {
    public ConceptSchemeRefType(ItemSchemeTypeCodelistType clazz,ItemSchemePackageTypeCodelistType pack) {
        super(null,null,null,clazz,pack);
    }
}
