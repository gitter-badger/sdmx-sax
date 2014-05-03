/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.HashMap;
import sdmx.data.key.Key;

/**
 *
 * @author James
 */
public class Group {

    Key groupKey = null;
    
    HashMap map = new HashMap();
    public Group(){
    }
    
    public void putGroupValue(String concept,String value){
        map.put(concept, value);
    }
    public String getGroupValue(String concept){
        return (String)map.get(concept);
    }
}
