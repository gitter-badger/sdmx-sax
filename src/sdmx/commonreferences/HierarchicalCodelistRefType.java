/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.MaintainableTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="HierarchicalCodelistRefType">
		<xs:annotation>
			<xs:documentation>HierarchicalCodelistRefType contains a set of reference fields for a hierarchical codelist.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="MaintainableTypeCodelistType" use="optional" fixed="HierarchicalCodelist"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class HierarchicalCodelistRefType extends MaintainableRefBaseType {
     public HierarchicalCodelistRefType(NestedNCNameIDType agencyId,IDType id,VersionType vers) {
         super(agencyId,id,vers,MaintainableTypeCodelistType.HIERARCHICALCODELIST,ItemSchemePackageTypeCodelistType.CODELIST);
     }
}
