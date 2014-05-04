/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import sdmx.data.key.FullKey;
import sdmx.data.key.Key;
import sdmx.data.key.PartialKey;

/**
 *
 * @author James
 */
public class Group {
    private String groupName = null;
    private HashMap<String,String> groupKey = new HashMap<String,String>();
    private HashMap<String,String> groupAttributes = new HashMap<String,String>();

    HashMap<String, String> map = new HashMap<String, String>();

    public Group() {
    }

    public Group(HashMap<String, String> groupValues) {
        this.map=groupValues;
    }

    public void putGroupValue(String concept, String value) {
        map.put(concept, value);
    }

    public String getGroupValue(String concept) {
        System.out.println("Get Group Value:"+concept);
        System.out.println("Returning:"+groupAttributes.get(concept));
        return groupAttributes.get(concept);
    }

    public void processGroupValues(DataSet ds) {
        groupAttributes = new HashMap<String, String>();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (ds.getColumnMapper().getColumnIndex(s) == -1||ds.getColumnMapper().isAttachedToGroup(s)) {
                groupAttributes.put(s, map.get(s));
                if(!ds.getColumnMapper().isAttachedToGroup(s))ds.getColumnMapper().registerColumn(s, AttachmentLevel.GROUP);
                it.remove();
            }else {
                getGroupKey().put(s, map.get(s));
                it.remove();
            }
        }
        this.map=null;
    }
    public boolean matches(FullKey key) {
        Iterator<String> it = getGroupKey().keySet().iterator();
        while(it.hasNext()){
            String s = it.next();
            Object gv = getGroupKey().get(s);
            if( gv!=null) {
                if( !gv.equals(key.getComponent(s))){
                    System.out.println("s="+s+":gv="+gv+":k="+key.getComponent(s));
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the groupKey
     */
    public HashMap<String,String> getGroupKey() {
        return groupKey;
    }

    /**
     * @return the groupAttributes
     */
    public HashMap<String,String> getGroupAttributes() {
        return groupAttributes;
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setGroupValue(String columnName, String val) {
        groupAttributes.put(columnName, val);
    }
}

