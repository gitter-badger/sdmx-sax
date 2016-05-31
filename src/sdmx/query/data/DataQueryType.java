/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

/**
 *
 * @author James
 */

public class DataQueryType {
     private DataReturnDetailType returnDetails = null;
     private DataParametersType dataWhere = null;

    /**
     * @return the returnDetails
     */
    public DataReturnDetailType getReturnDetails() {
        return returnDetails;
    }

    /**
     * @param returnDetails the returnDetails to set
     */
    public void setReturnDetails(DataReturnDetailType returnDetails) {
        this.returnDetails = returnDetails;
    }

    /**
     * @return the dataWhere
     */
    public DataParametersType getDataWhere() {
        return dataWhere;
    }

    /**
     * @param dataWhere the dataWhere to set
     */
    public void setDataWhere(DataParametersType dataWhere) {
        this.dataWhere = dataWhere;
    }
    
}
