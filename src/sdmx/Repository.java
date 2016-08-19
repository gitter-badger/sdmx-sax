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
package sdmx;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.commonreferences.IDType;
import sdmx.commonreferences.NestedNCNameID;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.querykey.Query;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.util.QueryStringUtils;
import sdmx.version.common.ParseDataCallbackHandler;
import sdmx.version.common.ParseParams;

/**
 *
 * @author James
 */
public interface Repository {
    // Batch
    public DataMessage query(Query query) throws ParseException,IOException ;
    // Streaming
    public void query(Query query,ParseDataCallbackHandler handler) throws ParseException,IOException ;
}
