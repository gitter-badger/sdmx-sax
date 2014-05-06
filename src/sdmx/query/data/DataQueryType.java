/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

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
