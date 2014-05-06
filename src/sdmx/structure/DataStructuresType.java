/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.commonreferences.VersionType;
import sdmx.structure.category.CategorySchemeType;
import sdmx.structure.datastructure.DataStructureType;

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
public class DataStructuresType {
    private List<DataStructureType> dataStructures = new ArrayList<DataStructureType>();

    /**
     * @return the dataStructures
     */
    public List<DataStructureType> getDataStructures() {
        return dataStructures;
    }

    /**
     * @param dataStructures the dataStructures to set
     */
    public void setDataStructures(List<DataStructureType> dataStructures) {
        this.dataStructures = dataStructures;
    }
    public DataStructureType findDataStructure(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = new VersionType(vers);
        return findDataStructure(ag,findid,ver);
    }
    public DataStructureType findDataStructure(NestedNCNameIDType agency2,IDType findid,VersionType ver) {
        for(int i=0;i<dataStructures.size();i++) {
            if( dataStructures.get(i).identifiesMe(agency2,findid,ver)) {
                return dataStructures.get(i);
            }
        }
        return null;
    }
    public DataStructureType findDataStructure(NestedNCNameIDType agency2,IDType findid) {
        for(int i=0;i<dataStructures.size();i++) {
            if( dataStructures.get(i).identifiesMe(agency2,findid)) {
                return dataStructures.get(i);
            }
        }
        return null;
    }
    public void dump() {
        for(int i=0;i<dataStructures.size();i++) {
            dataStructures.get(i).dump();
        }
    }
}
