/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.category;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.structure.base.Item;
import sdmx.structure.base.ItemType;

/**
 *
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
public class CategoryType extends ItemType {
    public CategoryType getCategory(int i){
        return (CategoryType)super.getItem(i);
    }
    public void setCategory(int i,CategoryType it){
        setItem(i, it);
    }
    public void removeCategory(CategoryType cat) {
        super.removeItem(cat);
    }
    public void setCategories(List<CategoryType> list) {
        List<ItemType> items = new ArrayList<ItemType>(list.size());
        items.addAll(list);
        super.setItems(items);
    }
    public CategoryType findCategory(String s) {
        return findCategory(new IDType(s));
    }
    public CategoryType findCategory(IDType id) {
        return (Category)super.findItem(id);
    }
    public void addCategory(CategoryType cat) {
        super.addItem(cat);
    }
}
