/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx;

import java.util.Iterator;
import java.util.List;
import sdmx.commonreferences.DataStructureReferenceType;
import sdmx.commonreferences.IDType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.version.twopointzero.Sdmx20SOAPQueryable;
import sdmx.registry.QueryableServiceRegistry;

/**
 *
 * @author James
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sdmx20SOAPQueryable queryable = new Sdmx20SOAPQueryable("ABS", "http://stat.abs.gov.au/sdmxws/sdmx.asmx");
        queryable.setSoapNamespace("http://stats.oecd.org/OECDStatWS/SDMX/");
        QueryableServiceRegistry registry = new QueryableServiceRegistry(queryable);
        List<DataStructureReferenceType> list = registry.listDataStructures();
        Iterator<DataStructureReferenceType> it = list.iterator();
        int retries = 3;
        int retry = 0;
        while (it.hasNext()) {
            DataStructureReferenceType ref = it.next();
            System.out.println(ref.getRef().getAgencyId() + ":" + ref.getRef().getId() + ":" + ref.getRef().getVersion());
            for (int i = 0; i < retries; i++) {
                try {
                    DataStructureType ds = registry.findDataStructure(ref.getRef().getAgencyId(), new IDType(ref.getRef().getId().toString()), ref.getRef().getVersion());
                    ds.dump();
                    i=retries+1;
               } catch (Exception ie) {
                   
               }
            }
        }
    }

}
