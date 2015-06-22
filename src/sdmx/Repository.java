/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;
import sdmx.util.QueryStringUtils;
import sdmx.version.common.ParseParams;

/**
 *
 * @author James
 */
public interface Repository {
    public DataMessage query(ParseParams params,DataQueryMessage message) throws ParseException,IOException ;
    // Dataflow must be set in ParseParams
    default DataMessage query(ParseParams params,String query) throws ParseException,IOException {
        return query(params,QueryStringUtils.toDataQueryMessage(params, query));
    }
}
