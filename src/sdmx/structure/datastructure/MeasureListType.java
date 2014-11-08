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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
