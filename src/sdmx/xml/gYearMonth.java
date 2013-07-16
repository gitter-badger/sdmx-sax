/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.xml;

import sdmx.common.GregorianTimePeriodType;

/**
 *
 * @author James
 */
public class gYearMonth {
    int year = 0;
    int month = 0;
    public gYearMonth(int y,int m){
        this.year=y;
        this.month=m;
    }
    public int getYear() { return year; }
    public int getMonth() { return month; }
}
