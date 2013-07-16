/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.ArrayList;
import java.util.List;
import sdmx.structure.base.Component;

/**
 *
 * @author James
 */
public class DimensionListType extends DimensionListBaseType {
    
   public List<DimensionType> getDimensions() {
       List<DimensionType> list = new ArrayList<DimensionType>();
       for(int i=0;i<super.getComponents().size();i++) {
           list.add( getDimension(i) );
       }
       return list;
   }
   
   public void setDimensions(List<DimensionType> at) {
       List<Component> list = new ArrayList<Component>();
       for(int i=0;i<at.size();i++) {
           list.add(at.get(i));
       }
       super.setComponents(list);
   }
   
   public DimensionType getDimension(int i) {
       Component c = getComponent(i);
       DimensionType at=(DimensionType)c;
       return (DimensionType) at;
   }
}
