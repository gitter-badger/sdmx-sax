/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.util.Iterator;
import java.util.List;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
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
    public static void main(String[] args) {
        Sdmx20SDWSOAPQueryable queryable = new Sdmx20SDWSOAPQueryable("ABS", "http://stat.abs.gov.au/sdmxws/sdmx.asmx");
        queryable.setSoapNamespace("http://stats.oecd.org/OECDStatWS/SDMX/");
        QueryableServiceRegistry registry = new QueryableServiceRegistry(queryable);
        List<DataflowType> list = registry.listDataflows();
        Iterator<DataflowType> it = list.iterator();
        int retries = 3;
        int retry = 0;
        while (it.hasNext()) {
            DataflowType ref = it.next();
            System.out.println(ref.getAgencyID() + ":" + ref.getId() + ":" + ref.getVersion());
            for (int i = 0; i < retries; i++) {
                try {
                    DataStructureType ds = registry.findDataStructure(ref.getAgencyID(), ref.getId().asID(), ref.getVersion());
                    ds.dump();
                    i=retries+1;
               } catch (Exception ie) {
                   
               }
            }
        }
    }

}
