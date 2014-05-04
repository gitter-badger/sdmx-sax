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
 *
 * @author James
 */
public class AbstractKey implements Key {

    private HashMap<String,String> map = new HashMap<String,String>();

    public AbstractKey(){}
    public AbstractKey(HashMap<String,String> map){
        this.map=map;
    }
    
    @Override
    public Object getComponent(String dim) {
        return map.get(dim);
    }

    @Override
    public void setComponent(String dim, String o) {
        map.put(dim, o);
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
}
