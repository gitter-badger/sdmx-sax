/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import sdmx.structure.dataflow.DataflowType;
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
public class DataflowsType {
    private List<DataflowType> dataflows = new ArrayList<DataflowType>(0);

    /**
     * @return the dataflows
     */
    public List<DataflowType> getDataflows() {
        return dataflows;
    }

    /**
     * @param dataflows the dataflows to set
     */
    public void setDataflows(List<DataflowType> dataflows) {
        this.dataflows = dataflows;
    }
    public DataflowType findDataflow(IDType findid) {
        for(int i=0;i<dataflows.size();i++) {
            if( dataflows.get(i).identifiesMe(findid)) return dataflows.get(i);
        }
        return null;
    }
    public DataflowType findDataflow(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameIDType ag = new NestedNCNameIDType(agency);
        VersionType ver = new VersionType(vers);
        return findDataflow(ag,findid,ver);
    }
    public DataflowType findDataflow(NestedNCNameIDType agency2,IDType findid,VersionType ver) {
        for(int i=0;i<dataflows.size();i++) {
            if( dataflows.get(i).identifiesMe(agency2,findid,ver)) {
                return dataflows.get(i);
            }
        }
        return null;
    }
    public void dump() {
        for(int i=0;i<dataflows.size();i++) {
            dataflows.get(i).dump();
        }
    }
}
