/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.ArrayList;
import java.util.List;
import sdmx.structure.base.Component;
import sdmx.structure.base.ComponentListType;

/**
 *
 * @author James
 */
public class MeasureListType extends ComponentListType {
    private PrimaryMeasure primary = null;

   public List<MeasureDimensionType> getMeasures() {
       List<MeasureDimensionType> list = new ArrayList<MeasureDimensionType>();
       for(int i=0;i<super.getComponents().size();i++) {
           list.add( getMeasure(i) );
       }
       return list;
   }
   
   public void setMeasures(List<MeasureDimensionType> at) {
       List<Component> list = new ArrayList<Component>();
       for(int i=0;i<at.size();i++) {
           list.add(at.get(i));
       }
       super.setComponents(list);
   }
   
   public MeasureDimensionType getMeasure(int i) {
       Component c = getComponent(i);
       MeasureDimensionType at=(MeasureDimensionType)c;
       return (MeasureDimensionType) at;
   }
    
    /**
     * @return the primary
     */
    public PrimaryMeasure getPrimaryMeasure() {
        return primary;
    }

    /**
     * @param primary the primary to set
     */
    public void setPrimaryMeasure(PrimaryMeasure primary) {
        this.primary = primary;
    }

    
}
