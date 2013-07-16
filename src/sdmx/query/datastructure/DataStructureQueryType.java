/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.datastructure;

import sdmx.message.QueryMessage;
import sdmx.query.base.MaintainableReturnDetailsType;

/**
 *
 * @author James
 */
public class DataStructureQueryType extends QueryMessage {
    private MaintainableReturnDetailsType returnDetails = null;
    private DataStructureWhereType dataStructureWhere = null;

    /**
     * @return the returnDetails
     */
    public MaintainableReturnDetailsType getReturnDetails() {
        return returnDetails;
    }

    /**
     * @param returnDetails the returnDetails to set
     */
    public void setReturnDetails(MaintainableReturnDetailsType returnDetails) {
        this.returnDetails = returnDetails;
    }

    /**
     * @return the dataStructureWhere
     */
    public DataStructureWhereType getDataStructureWhere() {
        return dataStructureWhere;
    }

    /**
     * @param dataStructureWhere the dataStructureWhere to set
     */
    public void setDataStructureWhere(DataStructureWhereType dataStructureWhere) {
        this.dataStructureWhere = dataStructureWhere;
    }
}
