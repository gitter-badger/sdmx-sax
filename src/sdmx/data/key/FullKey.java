/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.data.key;

import java.util.HashMap;
import sdmx.data.ColumnMapper;
import sdmx.data.flat.FlatObs;

/**
 * FullKey matches only a single observation
 * @author James
 */
public class FullKey extends AbstractKey {
    public FullKey() {
    }
    public FullKey(HashMap<String,String> map) {
        super(map);
    }
    public FullKey(FlatObs obs, ColumnMapper mapper) {
        for(int i=0;i<mapper.size();i++) {
            //System.out.println("Cname="+mapper.getColumnName(i)+":ov="+obs.getValue(i));
            setComponent(mapper.getColumnName(i),obs.getValue(i));
        }
    }
}
