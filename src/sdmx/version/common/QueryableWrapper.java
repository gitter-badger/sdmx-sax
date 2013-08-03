/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.version.common;

import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.message.DataStructure;

/**
 *
 * @author James
 */
public class QueryableWrapper {
    Queryable q = null;
    public QueryableWrapper(Queryable q) {
        this.q=q;
    }
    public DataStructure getDataStructure(DataStructureReferenceType ref) {
        return null;
    }
    
}
