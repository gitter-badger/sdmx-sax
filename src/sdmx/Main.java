/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.exception.ParseException;
import sdmx.registry.QueryableServiceRegistry;
import sdmx.structure.dataflow.DataflowType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.twopointzero.Sdmx20SDWSOAPQueryable;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ParseException {
        SdmxIO.parseStructure(new FileInputStream("test/resources/un-20/un.xml"));
    }

}
