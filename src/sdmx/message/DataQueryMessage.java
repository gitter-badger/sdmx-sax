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
