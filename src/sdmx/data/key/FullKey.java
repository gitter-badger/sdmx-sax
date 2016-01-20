/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.data.key;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;
import sdmx.structure.base.NameableType;

/**
 * FullKey matches only a single observation
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
public class FullKey extends AbstractKey {
    public FullKey() {
    }
    public FullKey(LinkedHashMap<String,Object> map) {
        super(map);
    }
    public FullKey(LinkedHashMap<String,Object> map,LinkedHashMap<String,Object> attrs) {
        super(map,attrs);
    }
    public FullKey(FlatObs obs, ColumnMapper mapper) {
        for(int i=0;i<mapper.size();i++) {
            //System.out.println("Cname="+mapper.getColumnName(i)+":ov="+obs.getValue(i));
            setComponent(mapper.getColumnName(i),obs.getValue(i));
        }
    }
    public FullKey clone() {
        return new FullKey((LinkedHashMap<String,Object>)map.clone());
    }

    public void dump() {
        Iterator<String> it = map.keySet().iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.print(s+":"+map.get(s));
            if(it.hasNext())System.out.print(",");
        }
        System.out.println();
    }
    public FullKey toStringKey(){
        FullKey key = new FullKey();
        Iterator<String> it = this.keySet().iterator();
        while(it.hasNext()) {
            String k = it.next();
            key.setComponent(k, NameableType.toIDString(this.getComponent(k)));
        }
        return key;
    }
    
}
