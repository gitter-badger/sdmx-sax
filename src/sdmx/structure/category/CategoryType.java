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
