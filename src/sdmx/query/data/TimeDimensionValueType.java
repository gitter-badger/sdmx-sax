/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import sdmx.commonreferences.NestedNCNameIDType;
import sdmx.query.base.TimeValue;
import sdmx.structure.datastructure.TimeDimensionType;

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
public class TimeDimensionValueType {

    private TimeValue start = null;
    private TimeValue end = null;
    public TimeDimensionValueType(TimeValue start, TimeValue end) {
        this.start=start;
        this.end=end;
    }

   public NestedNCNameIDType getId() {
     return TimeDimensionType.ID;
   }
    
    /**
     * @return the start
     */
    public TimeValue getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(TimeValue start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public TimeValue getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(TimeValue end) {
        this.end = end;
    }
    public boolean match(String s) {
// Ignore for now
        return true;
    }
    
}
