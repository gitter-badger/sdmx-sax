/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.model.freq;

import java.util.Calendar;
import java.util.Comparator;

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
public class TimeDetailComparator implements Comparator {
    public static final TimeDetailComparator INSTANCE = new TimeDetailComparator();
    private TimeDetailComparator(){
    }

    public int compare(Object o1, Object o2) {
        TimeDetail t1 = (TimeDetail)o1;
        TimeDetail t2 = (TimeDetail)o2;
        Calendar d1 = t1.getCalendar();
        Calendar d2 = t2.getCalendar();
        if( d1 == null ) return 0;
        if( d2 == null ) return 0;
        return d1.compareTo(d2);
    }
    

}
