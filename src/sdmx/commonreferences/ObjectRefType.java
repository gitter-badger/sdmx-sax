/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import sdmx.commonreferences.types.PackageTypeCodelistType;
import sdmx.commonreferences.types.ObjectTypeCodelistType;

/**
 *	<xs:complexType name="ObjectRefType">
		<xs:annotation>
			<xs:documentation>ObjectRefType contains a set of reference fields for the purpose of referencing any object. This cannot be a local reference, therefore the agency identifier is required. It is also required that the class and package be supplied for the referenced object such that a complete URN reference can be built from the values provided. Note that this is not capable of fully validating that all necessary fields are supplied for a given object type.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="RefBaseType">
				<xs:attribute name="agencyID" type="NestedNCNameIDType" use="required"/>
				<xs:attribute name="local" type="xs:boolean" use="optional" fixed="false"/>
				<xs:attribute name="class" type="ObjectTypeCodelistType" use="required"/>
				<xs:attribute name="package" type="PackageTypeCodelistType" use="required"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>
 * @author James
 */
public class ObjectRefType extends RefBaseType {
   public ObjectRefType(NestedNCNameIDType agencyId,boolean loc,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(agencyId,null,null,null,null,null,loc,obs,pack);
   }

}
