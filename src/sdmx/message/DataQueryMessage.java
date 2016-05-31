/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
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
