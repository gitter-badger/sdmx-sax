/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.LocalItemReferenceType;
import sdmx.commonreferences.NestedIDType;

/**
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
public abstract class ItemType extends ItemBaseType {

    private LocalItemReferenceType parent = null;
    private List<ItemType> items = new ArrayList<ItemType>(0);

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
            ItemType itm = items.get(i).findItem(id);
            if (itm != null) {
                return itm;
            }
            if (items.get(i).identifiesMe(id)) {
                return items.get(i);
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


}
