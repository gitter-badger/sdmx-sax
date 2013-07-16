/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;
import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="ReportCategoryRefType">
		<xs:annotation>
			<xs:documentation>ReportCategoryRefType contains a set of fields for referencing a reporting category within a reporting taxonomy.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the reporting taxonomy in which the reporting category being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the reporting taxonomy in which the reporting category being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="ReportingCategory"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="categoryscheme"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ReportCategoryRefType extends ItemRefBaseType {
    public ReportCategoryRefType(NestedNCNameIDType aid, IDType parentId,VersionType pVers,NestedIDType id){
        super(aid,parentId,pVers,id,ItemTypeCodelistType.REPORTINGCATEGORY,ItemSchemePackageTypeCodelistType.CATEGORYSCHEME);
    }
    
}
