/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.DataKeyType;

/**
 *
 * @author James
 */
public class DataKeySetType {
    List<DataKeyType> keys=new ArrayList<DataKeyType>();
    public DataKeyType getDataKey(int i) {
        return keys.get(i);
    }
    public void setDataKey(int i,DataKeyType dk) {
        keys.set(i,dk);
    }
}
