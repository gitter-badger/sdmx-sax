/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;

/**
 *
 * <xs:complexType name="LocalConceptRefType">
*		<xs:annotation>
*			<xs:documentation>LocalConceptRefType references a concept locally where the references to the concept scheme which defines it is provided elsewhere.</xs:documentation>
*		</xs:annotation>
*		<xs:complexContent>
*			<xs:restriction base="LocalItemRefBaseType">
*				<xs:attribute name="id" type="IDType" use="required"/>
*				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Concept"/>
*				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="conceptscheme"/>
*			</xs:restriction>
*		</xs:complexContent>
*	</xs:complexType>
*
 * @author James
 */
public class LocalConceptRefType extends LocalItemRefBaseType {
    public LocalConceptRefType(IDType id, ItemTypeCodelistType clazz, ItemSchemePackageTypeCodelistType pack){
        super(id,clazz,pack);
    }
}
