/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import sdmx.commonreferences.NestedNCNameID;
import sdmx.query.base.TimeValue;
import sdmx.structure.datastructure.TimeDimensionType;

/**
 *
 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class TimeDimensionValueType {

    private TimeValue start = null;
    private TimeValue end = null;
    public TimeDimensionValueType(TimeValue start, TimeValue end) {
        this.start=start;
        this.end=end;
    }

   public NestedNCNameID getId() {
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
