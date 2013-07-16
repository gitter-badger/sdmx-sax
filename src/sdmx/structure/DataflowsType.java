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
