/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import java.util.ArrayList;
import java.util.List;
import sdmx.data.Attachable;
import sdmx.data.AttachmentLevel;

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
public class Series implements Attachable {
    private List<String> columnValues = new ArrayList<String>();
    private StructuredColumnMapper columnMapper = null;
    private int start = -1;
    private int end = -1;
    private List<Obs> observations = new ArrayList<Obs>();
    public int size() {
        return getObservations().size();
    }

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @return the observations
     */
    public List<Obs> getObservations() {
        return observations;
    }

    /**
     * @param observations the observations to set
     */
    public void setObservations(List<Obs> observations) {
        this.observations = observations;
    }
    
    public String getValue(int row, int col) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            throw new RuntimeException("Can't access DataSet value from Series");
        }
        else if (attach == AttachmentLevel.SERIES) {
            return getValue(s);
        }
        return null;
    }


    public String getValue(int row, String col) {
        return getValue(row,columnMapper.getColumnIndex(col));
    }


    public void setValue(int row, int col, String val) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            getColumnValues().set(columnMapper.getDataSetIndex(s), val);
            return;
        }
        if (attach == AttachmentLevel.SERIES) {
            setValue(col, val);
        }
   }

    public void setValue(int row, String col, String val) {
        setValue(row,columnMapper.getSeriesIndex(col),val);
    }

    /**
     * @return the columnValues
     */
    public List<String> getColumnValues() {
        return columnValues;
    }

    /**
     * @param columnValues the columnValues to set
     */
    public void setColumnValues(List<String> columnValues) {
        this.columnValues = columnValues;
    }

    /**
     * @return the mapper
     */
    public StructuredColumnMapper getMapper() {
        return columnMapper;
    }

    /**
     * @param mapper the mapper to set
     */
    public void setMapper(StructuredColumnMapper mapper) {
        this.columnMapper = mapper;
    }

    @Override
    public String getValue(String s) {
        return getValue(columnMapper.getSeriesIndex(s));
    }

    @Override
    public void setValue(String s, String val) {
        if( !columnMapper.containsColumn(s)){
            columnMapper.registerColumn(s, AttachmentLevel.SERIES);
        }
        setValue(columnMapper.getSeriesIndex(s),val);
    }

    @Override
    public AttachmentLevel getAttachmentLevel() {
        return AttachmentLevel.SERIES;
    }

    @Override
    public String getValue(int i) {
        if( columnValues.size()>=i){
            for(int j=columnValues.size();j-1<i;j++) {
                columnValues.add(null);
            }
        }
        return columnValues.get(i);
    }

    @Override
    public void setValue(int i, String val) {
        if (columnValues.size() - 1 < i) {
            for (int j = columnValues.size(); (j - 1) < i; j++) {
                columnValues.add(null);
            }
        }
        columnValues.set(i, val);
    }

    public void updateIndexes(int start) {
        this.start=start;
        for(Obs o:observations){
            o.setRowId(this.start+observations.indexOf(o));
            //System.out.println("RowId="+o.getRowId());
        }
    }
    public boolean contains(int row) {
        if( start <= row && end-1 >= row && size()>0 ) return true;
        return false;
    }
    public void dump() {
        System.out.println("Start:"+start);
        System.out.println("End:"+end);
        System.out.println("Size:"+observations.size());
    }
    public Obs getObservationRow(int row) {
        //System.out.println("Looking for row:"+row);
        for(int i=0;i<observations.size();i++) {
            //System.out.println("SRowId="+observations.get(i).getRowId());
            if( observations.get(i).getRowId()==row) return observations.get(i);
        }
        return null;
    }
}
