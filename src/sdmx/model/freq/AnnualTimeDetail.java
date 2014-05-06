/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.model.freq;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
public class AnnualTimeDetail implements TimeDetail {

    private int year = 0;
    transient Calendar cal = null;

    public AnnualTimeDetail(String td) {
        year = Integer.parseInt(td);
        cal = Calendar.getInstance();
        cal.set(year, 1, 1);
    }

    public AnnualTimeDetail(Integer year) {
        this.year = year;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    public int compareTo(Object o2) {
        Object o1 = this;
        if (o1 instanceof AnnualTimeDetail && o2 instanceof AnnualTimeDetail) {
            AnnualTimeDetail ad = (AnnualTimeDetail) o1;
            AnnualTimeDetail ad2 = (AnnualTimeDetail) o2;
            return ad.getYear() - ad2.getYear();
        } else {
            System.out.println("o1=" + o1);
            System.out.println("o2=" + o2);
            throw new RuntimeException("Not A Time Detail");
        }
    }

    public String toString() {
        return Integer.toString(year);
    }

    public int hashCode() {
        return Integer.toString(year).hashCode();
    }

    public boolean equals(Object o) {
        if (!(o instanceof AnnualTimeDetail)) {
            return false;
        } else {
            AnnualTimeDetail ad = (AnnualTimeDetail) o;
            return year == ad.getYear();
        }

    }

    public Calendar getCalendar() {
        return cal;
    }

    public String getTimeFormat() {
        return "P1Y";
    }
}
