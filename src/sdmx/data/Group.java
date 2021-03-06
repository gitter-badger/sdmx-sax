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
package sdmx.data;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
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
    private LinkedHashMap<String,Object> groupKey = new LinkedHashMap<String,Object>();
    private HashMap<String,Object> groupAttributes = new HashMap<String,Object>();

    HashMap<String, Object> map = new HashMap<String, Object>();

    public Group() {
    }

    public Group(HashMap<String, Object> groupValues) {
        this.map=groupValues;
    }

    public void putGroupValue(String concept, Object value) {
        map.put(concept, value);
    }

    public Object getGroupValue(String concept) {
        return groupAttributes.get(concept);
    }

    public void processGroupValues(DataSet ds) {
        groupAttributes = new HashMap<String, Object>();
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String s = it.next();
            if (ds.getColumnMapper().getColumnIndex(s) == -1||ds.getColumnMapper().isAttachedToGroup(s)) {
                //System.out.println("Group Dim:"+s);
                groupAttributes.put(s, map.get(s));
                if(!ds.getColumnMapper().isAttachedToGroup(s)){
                    //System.out.println("Register:"+s);
                    ds.getColumnMapper().registerColumn(s, AttachmentLevel.GROUP);
                }
                it.remove();
            }else {
                //System.out.println("Group Attr:"+s);
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
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return the groupKey
     */
    public LinkedHashMap<String,Object> getGroupKey() {
        return groupKey;
    }

    /**
     * @return the groupAttributes
     */
    public HashMap<String,Object> getGroupAttributes() {
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

