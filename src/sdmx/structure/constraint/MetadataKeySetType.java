/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.constraint;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.DataKeyType;
import sdmx.common.MetadataKeyType;

/**
 *
 * @author James
 */

public class MetadataKeySetType {
    List<MetadataKeyType> keys=new ArrayList<MetadataKeyType>();
    public MetadataKeyType getMetadataKey(int i) {
        return keys.get(i);
    }
    public void setMetadataKey(int i,MetadataKeyType dk) {
        keys.set(i,dk);
    }    
}
