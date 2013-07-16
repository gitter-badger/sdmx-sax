/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.Name;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.structure.codelist.CodeType;

/**
 *	<xs:complexType name="ItemSchemeType" abstract="true">
		<xs:annotation>
			<xs:documentation>ItemSchemeType is an abstract base type for all item scheme objects. It contains a collection of items. Concrete instances of this type should restrict the actual types of items allowed within the scheme.</xs:documentation>
		</xs:annotation>
		<xs:complexContent>
			<xs:extension base="MaintainableType">
				<xs:sequence>
					<xs:sequence minOccurs="0" maxOccurs="unbounded">
						<xs:element ref="Item"/>
					</xs:sequence>
				</xs:sequence>
				<xs:attribute name="isPartial" type="xs:boolean" use="optional" default="false">
					<xs:annotation>
						<xs:documentation>The isPartial, if true, indicates that only the relevant portion of the item scheme is being communicated. This is used in cases where a codelist is returned for a key family in the context of a constraint.</xs:documentation>
					</xs:annotation>
				</xs:attribute>
			</xs:extension>
		</xs:complexContent>
	</xs:complexType>

 * @author James
 */
public class ItemSchemeType extends MaintainableType {
    private List<ItemType> items = new ArrayList<ItemType>(0);
    private boolean partial = false;

    /**
     * @return the items
     */
    public List<ItemType> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<ItemType> items) {
        this.items = items;
    }

    /**
     * @return the partial
     */
    public boolean isPartial() {
        return partial;
    }

    /**
     * @param partial the partial to set
     */
    public void setPartial(boolean partial) {
        this.partial = partial;
    }
    public ItemType getItem(int i){
        return items.get(i);
    }
    public void setItem(int i,ItemType it){
        items.set(i, it);
    }
    public void removeItem(ItemType it) {
        items.remove(it);
    }
    public void addItem(ItemType it) {
        items.add(it);
    }
    public int size() {
        return items.size();
    }
    public ItemType findItem(String s) {
        return findItem(new IDType(s));
    }
    public ItemType findItem(IDType id) {
        if( id == null ) return null;
        for(int i=0;i<items.size();i++) {
            if( items.get(i).identifiesMe(id)){
                return items.get(i);
            }
            ItemType itm = items.get(i).findItem(id);
            if( itm!=null)return itm;
        }
        return null;
    }
    public ItemType findItem(NestedIDType id) {
        if( id == null ) return null;
        for(int i=0;i<items.size();i++) {
            if( items.get(i).identifiesMe(id)){
                return items.get(i);
            }
            ItemType itm = items.get(i).findItem(id);
            if( itm!=null)return itm;
        }
        return null;
    }

}
