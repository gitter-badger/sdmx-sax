/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.flat;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author James
 */
public class FlatObs {
     List<Object> values = null;
     public FlatObs(int i){
         values = new ArrayList<Object>(i);
     }
     public FlatObs(List<Object> vals){
         values = vals;
     }
     public void setValue(int i, Object o) {
         if( values.size()<=i) {
             for(int j=values.size();j<=i;j++) {
                 values.add(null);
             }
         }
         values.set(i,o);
     }
     public Object getValue(int i) {
         if( i>=values.size() ) return null;
         return values.get(i);
     }
}
