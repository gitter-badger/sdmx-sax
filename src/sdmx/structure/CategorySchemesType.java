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
