/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;
import sdmx.xml.anyURI;

/**
 *	<xs:complexType name="IdentifiableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>IdentifiableWhereType is an abstract base type that serves as the basis for any query for an identifiable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="AnnotableWhereType">
				<xs:sequence>
					<xs:element name="URN" type="xs:anyURI" minOccurs="0">
						<xs:annotation>
							<xs:documentation>URN is used to match the urn of any SDMX object.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="ID" type="QueryIDType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>ID is used to match the id of the identified object.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
			</xs:extension>
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
public class IdentifiableWhereType extends AnnotableWhereType {
    private List<anyURI> urn = null;
    private List<QueryIDType> id = null;

    /**
     * @return the urn
     */
    public List<anyURI> getUrn() {
        return urn;
    }

    /**
     * @param urn the urn to set
     */
    public void setUrn(List<anyURI> urn) {
        this.urn = urn;
    }

    /**
     * @return the id
     */
    public List<QueryIDType> getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(List<QueryIDType> id) {
        this.id = id;
    }
}
