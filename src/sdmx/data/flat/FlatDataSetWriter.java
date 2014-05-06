/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.flat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSetWriter;
import sdmx.data.Group;

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
public class FlatDataSetWriter implements DataSetWriter {
    private ColumnMapper mapper = new FlatColumnMapper();
    private FlatDataSet dataSet = null;
    private List<String> dataSetValues = null;
    private List<String> seriesValues = null;
    private List<String> obsValues = null;
    List<Group> groups = null;

    public FlatDataSetWriter(){}
    public FlatDataSetWriter(ColumnMapper mapper) {
       this.mapper=(ColumnMapper) mapper;
    }
    
    
    @Override
    public void newDataSet() {
        dataSet = new FlatDataSet();
        dataSetValues = new ArrayList<String>();
    }

    @Override
    public void newSeries() {
        seriesValues = new ArrayList<String>();
        for (int i = 0; i < dataSetValues.size(); i++) {
            seriesValues.add(dataSetValues.get(i));
        }
    }

    @Override
    public void newObservation() {
        obsValues = new ArrayList<String>();
        for (int i = 0; i < seriesValues.size(); i++) {
            obsValues.add(seriesValues.get(i));
        }

    }
    
    @Override
    public void writeDataSetComponent(String name, String val) {
        if (!dataSet.getColumnMapper().containsColumn(name)) {
            dataSet.registerColumn(name);
        }
        dataSetValues.add(val);
    }

    @Override
    public void writeSeriesComponent(String name, String val) {
        if (!dataSet.getColumnMapper().containsColumn(name)) {
            dataSet.registerColumn(name);
        }
        seriesValues.add(val);
    }

    @Override
    public void writeObservationComponent(String name, String val) {
        if (!dataSet.getColumnMapper().containsColumn(name)) {
            dataSet.registerColumn(name);
        }
        obsValues.add(val);
    }

    @Override
    public void finishSeries() {
        
    }

    @Override
    public void finishObservation() {
        dataSet.addObservation(new FlatObs(obsValues));
    }

    @Override
    public FlatDataSet finishDataSet() {
        FlatDataSet ds = dataSet;
        ds.setGroups(groups);
        dataSet=null;
        return ds;
    }
    private void setDataSet(int i,String val) {
        if( dataSetValues.size()<i ) {
            for(int j=dataSetValues.size();j<i;j++) {
                dataSetValues.add(null);
            }
        }
        dataSetValues.set(i, val);
    }
    private void setSeries(int i,String val) {
        if( seriesValues.size()<i ) {
            for(int j=seriesValues.size();j<i;j++) {
                seriesValues.add(null);
            }
        }
        seriesValues.set(i,val);
    }
    private void setObservation(int i,String val) {
        if( obsValues.size()<i ) {
            for(int j=obsValues.size();j<i;j++) {
                obsValues.add(null);
            }
        }
        obsValues.set(i,val);
    }

    @Override
    public ColumnMapper getColumnMapper() {
        return mapper;
    }

    @Override
    public void writeGroupValues(String name,HashMap<String, String> groupValues) {
        Group group = new Group(groupValues);
        group.setGroupName(name);
        if(this.groups==null) {
            this.groups = new ArrayList<Group>();
        }
        groups.add(group);
    }
}
