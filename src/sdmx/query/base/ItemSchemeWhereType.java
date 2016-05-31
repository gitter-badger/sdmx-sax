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
