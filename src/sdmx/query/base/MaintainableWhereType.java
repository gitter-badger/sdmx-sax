/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import sdmx.commonreferences.types.MaintainableTypeCodelistType;

/**
 *	<xs:complexType name="MaintainableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>MaintainableQueryType is an abstract base type that serves as the basis for any query for a maintainable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="VersionableWhereType">
				<xs:sequence>
					<xs:element name="AgencyID" type="QueryNestedIDType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>AgencyID is used to match the agency id of the maintained object.</xs:documentation>
						</xs:annotation>
					</xs:element>
				</xs:sequence>
				<xs:attribute name="type" type="common:MaintainableTypeCodelistType" use="optional">
					<xs:annotation>
						<xs:documentation>The type attribute optionally defines the type of object being queried. For queries for distinct types of objects, a fixed value should be specified in the derived queries. For queries that serve to query for like types of objects, this should be required.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
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
public class MaintainableWhereType extends VersionableWhereType {
    private QueryNestedIDType agencyId = null;
    private MaintainableTypeCodelistType type = null;

    /**
     * @return the agencyId
     */
    public QueryNestedIDType getAgencyId() {
        return agencyId;
    }

    /**
     * @param agencyId the agencyId to set
     */
    public void setAgencyId(QueryNestedIDType agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * @return the type
     */
    public MaintainableTypeCodelistType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(MaintainableTypeCodelistType type) {
        this.type = type;
    }
}
