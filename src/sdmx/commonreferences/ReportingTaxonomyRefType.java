/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemeTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="ReportingTaxonomyRefType">
		<xs:annotation>
			<xs:documentation>ReportingTaxonomyRefType provides a reference to a reporting taxonomy via a complete set of reference fields.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemSchemeRefBaseType">
				<xs:attribute name="class" type="ItemSchemeTypeCodelistType" use="optional" fixed="ReportingTaxonomy"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ReportingTaxonomyRefType extends ItemSchemeRefBaseType {
    public ReportingTaxonomyRefType(IDType id){
        super(null,id,null,ItemSchemeTypeCodelistType.REPORTINGTAXONOMY,ItemSchemePackageTypeCodelistType.CATEGORYSCHEME);
    }
}
