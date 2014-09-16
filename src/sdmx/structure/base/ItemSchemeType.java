/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sdmx.common.Name;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedIDType;
import sdmx.structure.codelist.CodeType;

/**
 * <xs:complexType name="ItemSchemeType" abstract="true">
 * <xs:annotation>
 * <xs:documentation>ItemSchemeType is an abstract base type for all item scheme
 * objects. It contains a collection of items. Concrete instances of this type
 * should restrict the actual types of items allowed within the
 * scheme.</xs:documentation>
 * </xs:annotation>
 * <xs:complexContent>
 * <xs:extension base="MaintainableType">
 * <xs:sequence>
 * <xs:sequence minOccurs="0" maxOccurs="unbounded">
 * <xs:element ref="Item"/>
 * </xs:sequence>
 * </xs:sequence>
 * <xs:attribute name="isPartial" type="xs:boolean" use="optional"
 * default="false">
 * <xs:annotation>
 * <xs:documentation>The isPartial, if true, indicates that only the relevant
 * portion of the item scheme is being communicated. This is used in cases where
 * a codelist is returned for a key family in the context of a
 * constraint.</xs:documentation>
 * </xs:annotation>
 * </xs:attribute>
 * </xs:extension>
 * </xs:complexContent>
 * </xs:complexType>
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
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

    public ItemType getItem(int i) {
        return items.get(i);
    }

    public void setItem(int i, ItemType it) {
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
        if (id == null) {
            return null;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).identifiesMe(id)) {
                return items.get(i);
            }
            ItemType itm = items.get(i).findItem(id);
            if (itm != null) {
                return itm;
            }
        }
        return null;
    }

    public ItemType findItem(NestedIDType id) {
        if (id == null) {
            return null;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).identifiesMe(id)) {
                return items.get(i);
            }
            ItemType itm = items.get(i).findItem(id);
            if (itm != null) {
                return itm;
            }
        }
        return null;
    }

    public List<ItemType> findSubItems(String s) {
        return findSubItems(new IDType(s));
    }

    public List<ItemType> findSubItems(IDType id) {
        List<ItemType> result = new LinkedList<ItemType>();
        if (id == null) {
            Iterator<ItemType> it = items.iterator();
            while (it.hasNext()) {
                ItemType item = it.next();
                if (item.getParent() == null) {
                    result.add(item);
                }
            }
        } else {
            Iterator<ItemType> it = items.iterator();
            while (it.hasNext()) {
                ItemType item = it.next();
                if (item.getParent()!=null&&item.getParent().getId().equals(id)) {
                    result.add(item);
                }
            }
        }
        return result;
    }
     public List<ItemType> findSubItems(NestedIDType id) {
        List<ItemType> result = new LinkedList<ItemType>();
        if (id == null) {
            Iterator<ItemType> it = items.iterator();
            while (it.hasNext()) {
                ItemType item = it.next();
                if (item.getParent() == null) {
                    result.add(item);
                }
            }
        } else {
            Iterator<ItemType> it = items.iterator();
            while (it.hasNext()) {
                ItemType item = it.next();
                if (item.getParent()!=null&&item.getParent().getId().equals(id)) {
                    result.add(item);
                }
            }
        }
        return result;
    }
}
