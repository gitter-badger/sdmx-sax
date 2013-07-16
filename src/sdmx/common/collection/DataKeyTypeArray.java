/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common.collection;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.DataKeyType;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;

/**
 *
 * @author James
 */
public class DataKeyTypeArray implements MetadataTargetRegionKeyTypeChoice {
     public List<DataKeyType> list = new ArrayList<DataKeyType>();
}
