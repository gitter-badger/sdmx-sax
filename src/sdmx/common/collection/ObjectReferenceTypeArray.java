/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.common.collection;

import java.util.ArrayList;
import java.util.List;
import sdmx.common.choice.MetadataTargetRegionKeyTypeChoice;
import sdmx.commonreferences.ObjectReferenceType;

/**
 *
 * @author James
 */
public class ObjectReferenceTypeArray implements MetadataTargetRegionKeyTypeChoice {
     public List<ObjectReferenceType> list = new ArrayList<ObjectReferenceType>();
}
