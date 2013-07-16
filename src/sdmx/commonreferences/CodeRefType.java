/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.ItemTypeCodelistType;
import sdmx.commonreferences.types.ItemSchemePackageTypeCodelistType;

/**
 *	<xs:complexType name="CodeRefType">
		<xs:annotation>
			<xs:documentation>CodeRefType references a code from within a codelist. Reference fields are required for both the scheme and the item.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="ItemRefBaseType">
				<xs:attribute name="maintainableParentID" type="IDType" use="required">
					<xs:annotation>
						<xs:documentation>The maintainableParentID references the codelist in which the code being referenced is defined.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="maintainableParentVersion" type="VersionType" use="optional" default="1.0">
					<xs:annotation>
						<xs:documentation>The maintainableParentVersion attribute references the version of the codelist in which the code being referenced is defined. If not supplied, a default value of 1.0 is assumed.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
				<xs:attribute name="id" type="IDType" use="required"/>
				<xs:attribute name="class" type="ItemTypeCodelistType" use="optional" fixed="Code"/>
				<xs:attribute name="package" type="ItemSchemePackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class CodeRefType extends ItemRefBaseType {
    public CodeRefType(IDType mparent,VersionType vpar, NestedIDType id, ItemTypeCodelistType obs,ItemSchemePackageTypeCodelistType pack) {
         super(null,mparent,vpar,id,obs,pack);
    }
}
