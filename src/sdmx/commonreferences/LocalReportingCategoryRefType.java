/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;

/**
 *	<xs:complexType name="LocalReportingCategoryRefType">
		<xs:annotation>
			<xs:documentation>LocalReportingCategoryRefType references a reporting category locally where the references to the reporting taxonomy which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalItemRefBaseType">
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="ReportingCategory"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class LocalReportingCategoryRefType extends LocalItemRefBaseType {
    public LocalReportingCategoryRefType(NestedIDType id) {
        super(id,ItemTypeCodelistType.REPORTINGCATEGORY,ItemSchemePackageTypeCodelistType.CATEGORYSCHEME);
    }
}
