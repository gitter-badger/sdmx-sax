/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="MaintainableRefType">
		<xs:annotation>
			<xs:documentation>MaintainableRefType contains a complete set of reference fields for referencing any maintainable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableRefBaseType">
				<xs:attribute name="class" type="ConcreteMaintainableTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class MaintainableRefType extends MaintainableRefBaseType {
   public MaintainableRefType(ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(null,null,null,obs,pack);
   }
}
