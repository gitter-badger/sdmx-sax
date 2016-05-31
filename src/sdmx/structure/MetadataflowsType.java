/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */

public class MetadataflowsType {
    private List<Metadataflow> dataflows = new ArrayList<Metadataflow>(0);

    /**
     * @return the dataflows
     */
    public List<Metadataflow> getDataflows() {
        return dataflows;
    }

    /**
     * @param dataflows the dataflows to set
     */
    public void setDataflows(List<Metadataflow> dataflows) {
        this.dataflows = dataflows;
    }


}
