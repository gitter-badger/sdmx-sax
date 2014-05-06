/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;

/**
 *	<xs:complexType name="ItemSchemeWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemSchemeQueryType is an abstract base type that serves as the basis for any query for an item scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableWhereType">
				<xs:sequence>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="ItemWhere"/>
					</xs:sequence>
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
public class ItemSchemeWhereType extends MaintainableWhereType {
      private List<ItemWhereType> itemWheres = null;

    /**
     * @return the itemWheres
     */
    public List<ItemWhereType> getItemWheres() {
        return itemWheres;
    }

    /**
     * @param itemWheres the itemWheres to set
     */
    public void setItemWheres(List<ItemWhereType> itemWheres) {
        this.itemWheres = itemWheres;
    }
}
