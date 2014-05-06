/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import sdmx.structure.category.CategorySchemeType;
import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.structure.categorisation.CategorisationType;

/**
 *
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = new VersionType(vers);
        return findCategoryScheme(ag,findid,ver);
    }
    public CategorySchemeType findCategoryScheme(NestedNCNameIDType agency2,IDType findid,VersionType ver) {
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
}
