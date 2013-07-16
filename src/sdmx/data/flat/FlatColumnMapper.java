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
public class FlatColumnMapper {
    List<String> columns = new ArrayList<String>();
    public int registerColumn(String s) {
        columns.add(s);
        return columns.indexOf(s);
    }
    public int getColumnIndex(String s) {
        return columns.indexOf(s);
    }
    public String getColumnName(int i) {
        return columns.get(i);
    }
    public int size() {
        return columns.size();
    }
    public boolean containsColumn(String name) {
        for(int i=0;i<columns.size();i++) {
            if( columns.get(i).equals(name))return true;
        }
        return false;
    }
}
