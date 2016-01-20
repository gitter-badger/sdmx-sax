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
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class FlatObs {
     List<String> values = null;
     public FlatObs(int i){
         values = new ArrayList<String>(i);
     }
     public FlatObs(List<String> vals){
         values = vals;
     }
     public void setValue(int i, String o) {
         if( values.size()<=i) {
             for(int j=values.size();(j-1)<i;j++) {
                 values.add(null);
             }
         }
         values.set(i,o);
     }
     public String getValue(int i) {
         if( i>=values.size() ) return null;
         return values.get(i);
     }
     public void dump() {
         for(int i=0;i<values.size();i++) {
             System.out.print(values.get(i));
             if( i<values.size())System.out.print(" ");
         }
     }
     public int size() {
         return values.size();
     }
     
}
