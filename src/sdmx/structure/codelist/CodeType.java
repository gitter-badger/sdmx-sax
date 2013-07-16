/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.codelist;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.LocalCodeReferenceType;
import sdmx.structure.base.ItemType;

/**
 *
 * @author James
 */
public class CodeType extends ItemType {
    LocalCodeReferenceType parent = null;
    public CodeType getCode(int i) {
        return (CodeType)super.getItem(i);
    }
    public void setCode(int i,CodeType c) {
        super.setItem(i, c);
    }

    public void setCodes(List<CodeType> codes) {
        List<ItemType> items = new ArrayList<ItemType>(codes.size());
        items.addAll(codes);
        super.setItems(items);
    }
    public String toString() {
        if( getDescriptions()!=null&&getDescriptions().size()>0){
            return getDescriptions().get(0).getText();
        }
        return super.getId().getString();
    }
}
