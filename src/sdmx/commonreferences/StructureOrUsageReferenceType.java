/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.commonreferences;

import java.net.URI;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="StructureOrUsageReferenceType">
		<xs:annotation>
			<xs:documentation>StructureOrUsageReferenceType is a specific type of a reference for referencing either a structure or a structure usage. It consists of a URN and/or a complete set of reference fields; agency, id and version. If the complete set of reference fields is used, it is required that a class and package be provided so that the type of object referenced is clear.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="MaintainableReferenceBaseType">
				<xs:choice>
					<xs:sequence>
						<xs:element name="Ref" type="StructureOrUsageRefType" form="unqualified"/>
						<xs:element name="URN" type="xs:anyURI" form="unqualified" minOccurs="0"/>
					</xs:sequence>
					<xs:element name="URN" type="xs:anyURI" form="unqualified"/>
				</xs:choice>
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
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class StructureOrUsageReferenceType extends MaintainableReferenceBaseType {
    public StructureOrUsageReferenceType(StructureOrUsageRefType ref, anyURI urn){
        super(ref,urn);
    }
    public StructureOrUsageReferenceType(anyURI urn){
        super(urn);
    }
}
