/*
    This file is part of sdmx-sax.

    sdmx-sax is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    sdmx-sax is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with sdmx-sax.  If not, see <http://www.gnu.org/licenses/>.
    Copyright (C) 2015 James Gardner
*/
package sdmx.data.key;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

/**
 *
 * @author James
 */

public class AbstractKey implements Key {

    protected LinkedHashMap<String,Object> map = new LinkedHashMap<String,Object>();
    protected LinkedHashMap<String,Object> attrs = new LinkedHashMap<String,Object>();

    public AbstractKey(){}
    public AbstractKey(LinkedHashMap<String,Object> map){
        this.map=map;
    }
    public AbstractKey(LinkedHashMap<String,Object> map,LinkedHashMap<String,Object> attrs){
        this.map=map;
        this.attrs=attrs;
    }
    
    @Override
    public Object getComponent(String dim) {
        return map.get(dim);
    }

    @Override
    public void setComponent(String dim, Object o) {
        map.put(dim, o);
    }
    @Override
    public Object getAttribute(String dim) {
        return attrs.get(dim);
    }

    @Override
    public void setAttribute(String dim, Object o) {
        attrs.put(dim, o);
    }
    public void clearAttributes(){
        attrs.clear();
    }

    @Override
    public boolean equals(Key key) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (!getComponent(s).equals(key.getComponent(s))) {
                return false;
            }
        }
        return true;
    }

    public boolean matches(FlatObs obs, ColumnMapper mapper) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (!getComponent(s).equals(obs.getValue(mapper.getColumnIndex(s)))) {
                return false;
            }

        }
        return true;
    }
    public boolean notMatches(FlatObs obs, ColumnMapper mapper) {
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (getComponent(s).equals(obs.getValue(mapper.getColumnIndex(s)))) {
                return true;
            }

        }
        return false;
    }
    public Set<String> keySet() {
        return map.keySet();
    }
    public Set<String> attributeKeySet() {
        return attrs.keySet();
    }
    public void dump() {
        System.out.println("Dump Key");
        Iterator<String> it = keySet().iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.println("Key:"+s+":"+getComponent(s));
        }
        it = attrs.keySet().iterator();
        while(it.hasNext()) {
            String s = it.next();
            System.out.println("Attribute:"+s+":"+getAttribute(s));
        }
    }
    public LinkedHashMap<String,Object> getKeyMap() {
        return this.map;
    }
}
