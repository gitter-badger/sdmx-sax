/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.message;

import sdmx.query.data.DataQueryType;

/**
 *
 * @author James
 */
public class DataQueryMessage extends QueryMessage {
    private BaseHeaderType header = null;
    private DataQueryType query = null;

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
    public DataQueryType getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(DataQueryType query) {
        this.query = query;
    }
}
