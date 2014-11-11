/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.sdmx.resources.sdmxml.schemas.v21.common.ActionType;
import org.sdmx.resources.sdmxml.schemas.v21.message.BaseHeaderType;
import org.sdmx.resources.sdmxml.schemas.v21.message.StructureHeaderType;
import sdmx.commonreferences.DataStructureReference;
import sdmx.commonreferences.IDType;
import sdmx.exception.ParseException;
import sdmx.message.StructureType;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        BaseHeaderType header = StructureHeaderType.Factory.newInstance();
        header.setDataSetAction(ActionType.APPEND);
        
    }

}
