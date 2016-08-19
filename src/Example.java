
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import sdmx.Queryable;
import sdmx.Registry;
import sdmx.Repository;
import sdmx.SdmxIO;
import sdmx.exception.ParseException;
import sdmx.message.DataMessage;
import sdmx.message.DataQueryMessage;
import sdmx.net.ServiceList;
import sdmx.net.list.DataProvider;
import sdmx.query.base.QueryIDType;
import sdmx.query.base.TimeValue;
import sdmx.query.data.DataParametersAndType;
import sdmx.query.data.DataParametersOrType;
import sdmx.query.data.DataParametersType;
import sdmx.query.data.DataQuery;
import sdmx.query.data.DimensionValueType;
import sdmx.query.data.TimeDimensionValueType;
import sdmx.structure.base.ComponentUtil;
import sdmx.structure.codelist.CodelistType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structureddata.StructuredDataMessage;
import sdmx.structureddata.StructuredDataSet;
import sdmx.structureddata.StructuredValue;
import sdmx.version.common.ParseParams;

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
/**
 *
 * @author James
 */
public class Example {

    public static void main(String args[]) throws MalformedURLException {
        // Set this to true to dump the SOAP query to System.out that has been 
        // created by the driver
        SdmxIO.setDumpQuery(false);
        DataProvider dp = ServiceList.getDataProvider(0, "ABS", "http://stat.abs.gov.au/sdmxws/sdmx.asmx", "http://stats.oecd.org/OECDStatWS/SDMX/", "Based on Australian Bureau of Statistics data", "Based on Australian Bureau of Statistics data");
        Queryable queryable = dp.getQueryable();
        Registry reg = queryable.getRegistry();
        Repository rep = queryable.getRepository();
        // List the dataflows on the server
        List<DataflowType> dataflows = reg.listDataflows();
    }
}
