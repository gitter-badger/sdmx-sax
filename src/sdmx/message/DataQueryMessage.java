/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.query.data.DataQuery;
import sdmx.query.data.DataQueryType;

/**
 *
 * @author James
 */
public class DataQueryMessage extends QueryMessage {
    private BaseHeaderType header = null;
    private DataQuery query = null;

    /**
     * @return the header
     */
    public BaseHeaderType getHeader() {
        return header;
    }

    /**
     * @param header the header to set
     */
    public void setHeader(BaseHeaderType header) {
        this.header = header;
    }

    /**
     * @return the query
     */
    public DataQuery getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(DataQuery query) {
        this.query = query;
    }
}
