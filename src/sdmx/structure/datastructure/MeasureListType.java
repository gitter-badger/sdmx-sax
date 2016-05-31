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
/*
    private List<MeasureDimensionType> measures = new ArrayList<MeasureDimensionType>();
   public List<MeasureDimensionType> getMeasures() {
       return measures;
   }
   
   public void setMeasures(List<MeasureDimensionType> at) {
       measures = at;
   }
   
   public MeasureDimensionType getMeasure(int i) {
       return measures.get(i);
   }
  */  
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
    public int size() {
        return 1;
    }
    
}
