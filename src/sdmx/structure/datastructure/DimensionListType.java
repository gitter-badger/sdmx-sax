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
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class DimensionListType extends DimensionListBaseType {

    
    private List<DimensionType> dimensions = new ArrayList<DimensionType>();
    private MeasureDimensionType measureDimension = null;
    private TimeDimensionType timeDimension = null;

    public List<DimensionType> getDimensions() {
        return dimensions;
    }

    public void setDimensions(List<DimensionType> at) {
        this.dimensions = at;
    }

    public DimensionType getDimension(int i) {
        return dimensions.get(i);
    }

    /**
     * @return the timeDimension
     */
    public TimeDimensionType getTimeDimension() {
        return timeDimension;
    }

    /**
     * @param timeDimension the timeDimension to set
     */
    public void setTimeDimension(TimeDimensionType timeDimension) {
        this.timeDimension = timeDimension;
    }
    public int size() { return dimensions.size(); }

    /**
     * @return the measureDimension
     */
    public MeasureDimensionType getMeasureDimension() {
        return measureDimension;
    }

    /**
     * @param measureDimension the measureDimension to set
     */
    public void setMeasureDimension(MeasureDimensionType measureDimension) {
        this.measureDimension = measureDimension;
    }
}
