/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.base;

import java.util.List;
import sdmx.commonreferences.LocalItemReferenceType;

/**
 *	<xs:complexType name="ItemWhereType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemQueryType is an abstract base type that serves as the basis for a query for an item within an item scheme query. A nested item where is provided to query for items nested within other items. The conditions within an item query are implied to be in an and-query. If an id and a child item where condition are supplied, then both conditions will have to met in order for the item query to return true. If, for instance, a query based on names in multiple languages is required, then multiple instances of the element utilizing this type should be used within an or-query container.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="NameableWhereType">
				<xs:choice minOccurs="0">
					<xs:element name="Parent" type="common:LocalItemReferenceType">
						<xs:annotation>
							<xs:documentation>Parent is used to query for an item where it declares the item referenced here as its parent. This is used for items that are not nested in a hierarchy. If child items are sought for an item that is contained in a nested hierarchy (e.g. a category) on can query directly for the parent category and request that the child items be returned by specifying cascadeMatchedItems in the detail field of the return details.</xs:documentation>
						</xs:annotation>
					</xs:element>
					<xs:sequence maxOccurs="unbounded">
						<xs:element ref="ItemWhere"/>
					</xs:sequence>					
				</xs:choice>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ItemWhereType extends NameableWhereType {
    private LocalItemReferenceType parent = null;
    private List<ItemWhereType> itemWheres = null;

    /**
     * @return the parent
     */
    public LocalItemReferenceType getParent() {
        return parent;
    }

    /**
     * @param parent the parent to set
     */
    public void setParent(LocalItemReferenceType parent) {
        this.parent = parent;
    }

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
