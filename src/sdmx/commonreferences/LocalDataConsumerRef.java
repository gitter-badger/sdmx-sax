/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences;

import sdmx.commonreferences.types.OrganisationTypeCodelistType;

/**
 *	<xs:complexType name="LocalDataConsumerRefType">
		<xs:annotation>
			<xs:documentation>LocalDataConsumerRefType references a data consumer locally where the reference to the data consumer scheme which defines it is provided elsewhere.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:restriction base="LocalOrganisationRefBaseType">
				<xs:attribute name="class" type="OrganisationTypeCodelistType" use="optional" fixed="DataConsumer"/>
			</xs:restriction>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class LocalDataConsumerRef extends LocalOrganisationRefBase {
    public LocalDataConsumerRef(IDType id){
        super(id,OrganisationTypeCodelistType.DATACONSUMER);
    }
    
}
