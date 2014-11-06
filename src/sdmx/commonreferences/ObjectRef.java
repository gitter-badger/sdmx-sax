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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *  SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */

public class ObjectRef extends RefBase {
   public ObjectRef(NestedNCNameID agencyId,boolean loc,ObjectTypeCodelistType obs,PackageTypeCodelistType pack) {
       super(agencyId,null,null,null,null,null,loc,obs,pack);
   }

}
