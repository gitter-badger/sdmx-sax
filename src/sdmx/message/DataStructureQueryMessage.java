/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.query.datastructure.DataStructureWhereType;

/**
 *
 * @author James
 */
public class DataStructureQueryMessage extends QueryMessage {
    DataStructureWhereType where = null;
    public DataStructureWhereType getDataStructureWhereType() {
        return where;
    }
    public void setDataStructureWhereType(DataStructureWhereType where) {
        this.where=where;
    }
}
