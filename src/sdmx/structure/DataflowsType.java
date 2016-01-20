/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.DataflowReference;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedID;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.commonreferences.Version;
import sdmx.structure.categorisation.CategorisationType;
import sdmx.structure.dataflow.DataflowType;

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
    public DataflowType findDataflow(NestedID findid) {
        for(int i=0;i<dataflows.size();i++) {
            if( dataflows.get(i).identifiesMe(findid)) return dataflows.get(i);
        }
        return null;
    }
    public DataflowType findDataflow(String agency,String id,String vers) {
        IDType findid = new IDType(id);
        NestedNCNameID ag = new NestedNCNameID(agency);
        Version ver = new Version(vers);
        return findDataflow(ag,findid,ver);
    }
    public DataflowType findDataflow(NestedNCNameID agency2,NestedID findid,Version ver) {
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
    public DataflowType find(DataflowReference ref) {
        for(int i=0;i<dataflows.size();i++) {
            if( dataflows.get(i).identifiesMe(ref.getAgencyId(),ref.getMaintainableParentId(),ref.getVersion())) {
                return dataflows.get(i);
            }
        }
        return null;
    }

    public void merge(DataflowsType dataflows) {
        this.getDataflows().addAll(dataflows.getDataflows());
    }
}
