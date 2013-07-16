/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common.collection;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.SimpleKeyValueType;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;

/**
 *
 * @author James
 */
public class SimpleKeyValueTypeArray implements MetadataTargetRegionKeyTypeChoice {
     public List<SimpleKeyValueType> list = new ArrayList<SimpleKeyValueType>();
}
