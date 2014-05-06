/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.metrics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sdmx.commonreferences.IDType;
import sdmx.data.DataSet;
import sdmx.combined.ValueTypeResolver;
import sdmx.structure.base.Component;
import sdmx.structure.base.ComponentList;
import sdmx.structure.datastructure.DataStructureType;

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
public class DataSetMetrics {
    public static final int TYPE_DIMENSION = 0;
    public static final int TYPE_ATTRIBUTE = 1;
    public static final int TYPE_MEASURE = 2;
    public static final int TYPE_TIMEDIMENSION = 3;
    public static final int TYPE_UNKNOWN = -1;
    DataSet dataSet = null;
    ValueTypeResolver res = null;
    DataStructureType struct = null;
    Map<String,Integer> uniqueValues = new HashMap<String,Integer>();
    Map<String,Integer> columnDisplay = new HashMap<String,Integer>();
    
    public static final int DISPLAY_DIMENSION_SINGLE = 0;
    public static final int DISPLAY_DIMENSION_DROP_DOWN = 1;
    public static final int DISPLAY_DIMENSION_MULTILIST = 2;
    public static final int DISPLAY_DIMENSION_TEXTFIELD = 3;
    public static final int DISPLAY_TIME_LATEST = 4;
    public static final int DISPLAY_TIME_SLIDER = 5;
    
    public DataSetMetrics(DataSet ds,ValueTypeResolver res,DataStructureType struct) {
        this.dataSet=ds;
        this.res=res;
        this.struct=struct;
        for(int i=0;i<struct.getDataStructureComponents().getComponents().size();i++){
            ComponentList c = struct.getDataStructureComponents().getComponents().get(i);
            for(int j=0;j<c.size();j++) {
                uniqueValues.put(c.getComponent(i).getId().getString(), enumerateValues(c.getId()).size());
            }
        }
    }

    private int observations;
    private int series;
    private int dimensions;
    private int attributes;

    public int getColumnType(IDType col) {
        for (int i = 0; i < struct.getDataStructureComponents().getDimensionList().size(); i++) {
            if (struct.getDataStructureComponents().getDimensionList().getDimension(i).identifiesMe(col)) {
                return TYPE_DIMENSION;
            }
        }
        for (int i = 0; i < struct.getDataStructureComponents().getAttributeList().size(); i++) {
            if (struct.getDataStructureComponents().getAttributeList().getAttribute(i).identifiesMe(col)) {
                return TYPE_ATTRIBUTE;
            }
        }
        for (int i = 0; i < struct.getDataStructureComponents().getMeasureList().size(); i++) {
            if (struct.getDataStructureComponents().getMeasureList().getMeasure(i).identifiesMe(col)) {
                return TYPE_MEASURE;
            }
        }
        if(struct.getDataStructureComponents().getTimeDimension().identifiesMe(col)) {
            return TYPE_TIMEDIMENSION;
        }
        return TYPE_UNKNOWN;
    }

    public List<Object> enumerateValues(String col) {
        List<Object> result = new ArrayList<Object>();
        for(int i=0;i<dataSet.size();i++) {
            if( !result.contains(dataSet.getValue(i, dataSet.getColumnIndex(col))))result.add(dataSet.getValue(i, dataSet.getColumnIndex(col)));
        }
        return result;
    }
    public List<Object> enumerateValues(IDType col) {
        return enumerateValues(col.getString());
    }
    public int getUniqueValues(String col) {
        return uniqueValues.get(col);
    }
    public int getUniqueValues(IDType col) {
        return uniqueValues.get(col.getString());
    }
}
