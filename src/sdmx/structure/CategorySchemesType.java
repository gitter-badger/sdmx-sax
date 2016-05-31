/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;
import sdmx.structure.categorisation.CategorisationType;
import sdmx.structure.category.CategorySchemeType;

/**
 *
 * @author James
 */

public class CategorySchemesType {
    private List<CategorySchemeType> categorySchemes = new ArrayList<CategorySchemeType>();

    /**
     * @return the categorySchemes
     */
    public List<CategorySchemeType> getCategorySchemes() {
        return categorySchemes;
    }

    /**
     * @param categorySchemes the categorySchemes to set
     */
    public void setCategorySchemes(List<CategorySchemeType> categorySchemes) {
        this.categorySchemes = categorySchemes;
    }
    public CategorySchemeType findCategoryScheme(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameID ag = new NestedNCNameID(agency);
        Version ver = new Version(vers);
        return findCategoryScheme(ag,findid,ver);
    }
    public CategorySchemeType findCategoryScheme(NestedNCNameID agency2,NestedID findid,Version ver) {
        for(int i=0;i<categorySchemes.size();i++) {
            if( categorySchemes.get(i).identifiesMe(agency2,findid,ver)) {
                return categorySchemes.get(i);
            }
        }
        return null;
    }
    public void dump() {
        for(int i=0;i<categorySchemes.size();i++) {
            categorySchemes.get(i).dump();
        }
    }

    public void merge(CategorySchemesType categorySchemes) {
        this.getCategorySchemes().addAll(categorySchemes.getCategorySchemes());
    }
}
