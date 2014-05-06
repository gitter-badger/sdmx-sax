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
