/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.metrics;

import java.util.ArrayList;
import java.util.List;
import sdmx.commonreferences.IDType;
import sdmx.data.DataSet;
import sdmx.data.ValueTypeResolver;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class DataSetMetrics {

    public int DIMENSION = 0;
    public int ATTRIBUTE = 1;
    public int MEASURE = 2;
    public int TIMEDIMENSION = 3;
    public int UNKNOWN = -1;
    DataSet dataSet = null;
    ValueTypeResolver res = null;
    DataStructureType struct = null;

    public DataSetMetrics(DataSet ds,ValueTypeResolver res,DataStructureType struct) {
        this.dataSet=ds;
        this.res=res;
        this.struct=struct;
    }

    private int observations;
    private int series;
    private int dimensions;
    private int attributes;

    public int getColumnType(IDType col) {
        for (int i = 0; i < struct.getDataStructureComponents().getDimensionList().size(); i++) {
            if (struct.getDataStructureComponents().getDimensionList().getDimension(i).identifiesMe(col)) {
                return DIMENSION;
            }
        }
        for (int i = 0; i < struct.getDataStructureComponents().getAttributeList().size(); i++) {
            if (struct.getDataStructureComponents().getAttributeList().getAttribute(i).identifiesMe(col)) {
                return ATTRIBUTE;
            }
        }
        for (int i = 0; i < struct.getDataStructureComponents().getMeasureList().size(); i++) {
            if (struct.getDataStructureComponents().getMeasureList().getMeasure(i).identifiesMe(col)) {
                return MEASURE;
            }
        }
        if(struct.getDataStructureComponents().getTimeDimension().identifiesMe(col)) {
            return TIMEDIMENSION;
        }
        return UNKNOWN;
    }

    public List<Object> enumerateValues(String col) {
        List<Object> result = new ArrayList<Object>();
        for(int i=0;i<dataSet.size();i++) {
            if( !result.contains(dataSet.getValue(i, dataSet.getColumnIndex(col))))result.add(dataSet.getValue(i, dataSet.getColumnIndex(col)));
        }
        return result;
    }
}
