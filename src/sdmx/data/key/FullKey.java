/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.data.key;

import java.util.HashMap;
import java.util.Iterator;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

/**
 * FullKey matches only a single observation
 * @author James
 */
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
 */
public class FullKey extends AbstractKey {
    public FullKey() {
    }
    public FullKey(HashMap<String,Object> map) {
        super(map);
    }
    public FullKey(FlatObs obs, ColumnMapper mapper) {
        for(int i=0;i<mapper.size();i++) {
            //System.out.println("Cname="+mapper.getColumnName(i)+":ov="+obs.getValue(i));
            setComponent(mapper.getColumnName(i),obs.getValue(i));
        }
    }
    public FullKey clone() {
        return new FullKey((HashMap)map.clone());
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
}
