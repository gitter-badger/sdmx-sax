/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.xml;

import java.util.Calendar;
import sdmx.common.GregorianTimePeriodType;

/**
 *
 * @author James
 *//**
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

public class DateType {//implements GregorianTimePeriodType{
     int year = 0;
     int month = 0;
     int date = 0;
     public DateType(int year,int month,int d) {
         this.year=year;
         this.month=month;
         this.date=d;
     }
     public int getYear() { return year; }
     public int getMonth() { return month; }
     public int getDate() { return date; }
}
