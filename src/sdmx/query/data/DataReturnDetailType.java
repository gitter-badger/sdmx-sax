/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import java.util.ArrayList;
import java.util.List;
import sdmx.exception.TypeValueNotFoundException;

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
public class DataReturnDetailType {

    public static final List<DataReturnDetailType> ENUM = new ArrayList<DataReturnDetailType>();
    public static final List<String> STRING_ENUM = new ArrayList<String>();
    
    public static final String FULL_TEXT = addString("Full");
    public static final String DATAONLY_TEXT = addString("DataOnly");
    public static final String SERIESKEYONLY_TEXT = addString("SeriesKeyOnly");
    public static final String NODATA_TEXT = addString("NoData");

    public static final DataReturnDetailType FULL = add(FULL_TEXT);
    public static final DataReturnDetailType DATAONLY = add(DATAONLY_TEXT);
    public static final DataReturnDetailType SERIESKEYONLY = add(SERIESKEYONLY_TEXT);
    public static final DataReturnDetailType NODATA = add(NODATA_TEXT);

// Utility
    private static DataReturnDetailType add(String s){
        DataReturnDetailType b = new DataReturnDetailType(s);
        ENUM.add(b);
        return b;
    }
    private static String addString(String s){
        STRING_ENUM.add(s);
        return s;
    }
    
    public static DataReturnDetailType fromString(String s) {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        return null;
    }
    public static DataReturnDetailType fromStringWithException(String s) throws TypeValueNotFoundException {
        for(int i=0;i<ENUM.size();i++) {
            if( ENUM.get(i).target.equals(s))return ENUM.get(i);
        }
        throw new TypeValueNotFoundException("Value:"+s+" not found in enumeration! - ObjectypeCodelistType");
    }
// Instance
    private String target = null;
    public DataReturnDetailType(String s) {
        if( !STRING_ENUM.contains(s))throw new IllegalArgumentException(s+" is not a valid DataReturnDetailsType");
        this.target=s;
    }
    public String toString() { return target; }
}
