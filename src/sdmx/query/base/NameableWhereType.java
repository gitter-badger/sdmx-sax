/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;

/**
 *	<xs:complexType name="NameableWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>NameableWhereType is an abstract base type that serves as the basis for any query for a nameable object.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="IdentifiableWhereType">
				<xs:sequence>
					<xs:element name="Name" type="QueryTextType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Name is used to match the name of the identified object. It may occur multiple times for its usage within an or-query or for multi-lingual searches, however if multiple values are supplied in an and-query (explicit or implicit), each name search will have to be found in order to constitute a match. The value here can either be an explicit value (exact match) or a regular expression pattern on which to match.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:element name="Description" type="QueryTextType" minOccurs="0">
						<xs:annotation>
							<xs:documentation>Description is used to match the description of the identified object. It may occur multiple times for its usage within an or-query or for multi-lingual searches, however if multiple values are supplied in an and-query (explicit or implicit), each description search will have to be found in order to constitute a match. The value here can either be an explicit value (exact match) or a regular expression pattern on which to match.</xs:documentation>
						</xs:annotation>
					</xs:element>					
				</xs:sequence>
			</xs:extension>
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
public class NameableWhereType extends IdentifiableWhereType {
    private List<QueryTextType> names = null;
    private List<QueryTextType> description = null;

    /**
     * @return the names
     */
    public List<QueryTextType> getNames() {
        return names;
    }

    /**
     * @param names the names to set
     */
    public void setNames(List<QueryTextType> names) {
        this.names = names;
    }

    /**
     * @return the description
     */
    public List<QueryTextType> getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(List<QueryTextType> description) {
        this.description = description;
    }
}
