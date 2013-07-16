/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.CodelistTypeCodelistType;
import sdmx.commonreferences.types.PackageTypeCodelistType;

/**
 *	<xs:complexType name="AnyCodelistRefType">
		<xs:annotation>
			<xs:documentation>AnyCodelistRefType is a type for referencing any codelist object (either a codelist or a hierarchical codelist).</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="CodelistTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="optional" fixed="codelist"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class AnyCodelistType extends MaintainableRefBaseType {
   public AnyCodelistType(CodelistTypeCodelistType obs) {
       super(null,null,null,obs,PackageTypeCodelistType.CODELIST);
   }
}
