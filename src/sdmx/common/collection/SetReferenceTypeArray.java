/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common.collection;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.SetReferenceType;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;

/**
 *
 * @author James
 */
public class SetReferenceTypeArray implements MetadataTargetRegionKeyTypeChoice {
     public List<SetReferenceType> list = new ArrayList<SetReferenceType>();
}
