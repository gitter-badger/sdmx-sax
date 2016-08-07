/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.querykey;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class QueryKey {
    List<QueryDimension> dims = new ArrayList<QueryDimension>();
     public QueryKey(DataStructureType ds,Registry reg){
         for(int i=0;i<ds.getDataStructureComponents().getDimensionList().size();i++) {
             dims.add(new QueryDimension(ds.getDataStructureComponents().getDimensionList().getDimension(i).getId().toString(),ds,reg));
         }
         if( ds.getDataStructureComponents().getDimensionList().getMeasureDimension()!=null ) {
             dims.add(new QueryDimension(ds.getDataStructureComponents().getDimensionList().getMeasureDimension().getId().toString(),ds,reg));
         }
         if( ds.getDataStructureComponents().getDimensionList().getTimeDimension()!=null ) {
             dims.add(new QueryDimension(ds.getDataStructureComponents().getDimensionList().getTimeDimension().getId().toString(),ds,reg));
         }
     }
     public List<String> getConceptNames() {
         List<String> result = new ArrayList<String>();
         for(int i=0;i<dims.size();i++) {
             result.add(dims.get(i).getConcept());
         }
         return result;
     }
     public QueryDimension getQueryDimension(int i) {
         return dims.get(i);
     }
     public List<QueryDimension> getQueryDimensions() {
         return this.dims; 
     }
}
