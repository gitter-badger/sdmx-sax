/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.structured;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.commonreferences.DataStructureReference;
import sdmx.cube.Cube;
import sdmx.data.Attachable;
import sdmx.data.AttachmentLevel;
import sdmx.data.ColumnMapper;
import sdmx.data.DataSet;
import sdmx.data.DataSetWriter;
import sdmx.data.Group;
import sdmx.data.flat.FlatDataSetWriter;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.data.key.PartialKey;
import sdmx.query.data.DataQuery;
import sdmx.structure.codelist.CodeType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structure.datastructure.DimensionType;

/**
 *
 * @author James
 */
/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
public class StructuredDataSet implements DataSet, Attachable {

    List<Group> groups = null;
    List<String> columnValues = new ArrayList<String>();
    private List<Series> series = new ArrayList<Series>();
    private List<Obs> observations = null;
    private StructuredColumnMapper columnMapper = new StructuredColumnMapper();

    public StructuredDataSet() {
    }

    public int getColumnIndex(String name) {
        return columnMapper.getColumnIndex(name);
    }

    public StructuredDataSet(StructuredColumnMapper mapper) {
        this.columnMapper = mapper;
    }

    public ColumnMapper getColumnMapper() {
        return columnMapper;
    }

    public Series getSeries(int i) {
        return series.get(i);
    }

    @Override
    public void dump() {
        for (int i = 0; i < columnMapper.size(); i++) {
            System.out.print(columnMapper.getAttachmentLevel(i).getName() + ":" + columnMapper.getColumnName(i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < columnMapper.size(); j++) {
                Object o = getValue(i, j);
                if (o == null) {
                    System.out.print("null\t");
                } else {
                    String c = o.getClass().getSimpleName();
                    System.out.print(o.toString() + ":" + c + "\t");
                }
                //System.out.print(getValue(i,j)+"\t");
            }
            System.out.println();
        }
    }

    @Override
    public String getColumnName(int i) {
        return columnMapper.getColumnName(i);
    }

    @Override
    public int getColumnSize() {
        return columnMapper.size();
    }

    @Override
    public int size() {
        if (observations != null) {
            return observations.size();
        }
        int result = 0;
        for (int i = 0; i < series.size(); i++) {
            result += series.get(i).size();
        }
        return result;
    }

    @Override
    public String getValue(int row, int col) {
        if (series.size() > 0) {
            AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
            String s = columnMapper.getColumnName(col);
            if (attach == AttachmentLevel.DATASET) {
                return columnValues.get(columnMapper.getDataSetIndex(s));
            } else if (attach == AttachmentLevel.SERIES) {
                Series series = findSeries(row);
                return series.getValue(columnMapper.getSeriesIndex(s));
            } else if (attach == AttachmentLevel.OBSERVATION) {
                Series series = findSeries(row);
                //System.out.println("Find Row:"+row+": Series="+series);
                //System.out.println("Find Row:"+row+": Obs="+series.getObservationRow(row));
                //series.dump();
                return series.getObservationRow(row).getValue(columnMapper.getObservationIndex(s));
            } else if (attach == AttachmentLevel.GROUP) {
                FlatObs flat = getFlatObsSansGroups(row);
                FullKey full = new FullKey(flat, columnMapper);
                for (int i = 0; i < groups.size(); i++) {
                    if (groups.get(i).matches(full)) {
                        return (String) groups.get(i).getGroupValue(columnMapper.getColumnName(col));
                    }
                }
                return null;
            } else {
                return null;
            }
        } else if (columnMapper.isAttachedToDataSet(col)) {
            return this.columnValues.get(columnMapper.getDataSetIndex(columnMapper.getColumnName(col)));
        } else {
            return observations.get(row).getValue(columnMapper.getObservationIndex(col));
        }
    }

    @Override
    public String getValue(int row, String col) {
        return getValue(row, columnMapper.getColumnIndex(col));
    }

    @Override
    public void setValue(int row, int col, String val) {
        AttachmentLevel attach = columnMapper.getAttachmentLevel(col);
        String s = columnMapper.getColumnName(col);
        if (attach == AttachmentLevel.DATASET) {
            columnValues.set(columnMapper.getDataSetIndex(s), val);
            return;
        }
        if (attach == AttachmentLevel.SERIES) {
            Series series = findSeries(row);
            series.setValue(columnMapper.getSeriesIndex(s), val);
        }
        if (attach == AttachmentLevel.OBSERVATION) {
            Series series = findSeries(row);
            Obs obs = series.getObservationRow(row);
            obs.setValue(columnMapper.getObservationIndex(s), val);
        }
        if (attach == AttachmentLevel.GROUP) {
            FlatObs flat = getFlatObsSansGroups(row);
            FullKey full = new FullKey(flat, columnMapper);
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).matches(full)) {
                    groups.get(i).setGroupValue(columnMapper.getColumnName(col), val);
                }
            }
        }
    }

    @Override
    public void setValue(int row, String col, String val) {
    }

    @Override
    public void writeTo(DataSetWriter writer) {
    }

    public AttachmentLevel getAttachmentLevel() {
        return AttachmentLevel.DATASET;
    }

    public Series findSeries(int row) {
        Series s = series.get(_findSeriesIndex(row));
        return s;
    }

    public int findSeriesIndex(int row) {
        return findSeriesIndex(row, 0, series.size() - 1);
    }

    public int findSeriesIndex(int row, int from, int to) {
        if (row == 0) {
            return 0;
        }
        //System.out.println("Find Row:"+row+": from:"+from+" to"+to);
        int half = ((to - from) / 2);

        if (series.get(from + half).contains(row)) {
            return from + half;
        }
        if (series.size() > to && series.get(to).contains(row)) {
            return to;
        }
        if (series.size() > from && series.get(from).contains(row)) {
            return from;
        }
        /*
         if( half == 0 ) {
         System.out.println("From="+from);
         System.out.println("To="+to);
         System.out.println("Half="+half);
         int actual = _findSeriesIndex(row);
         System.out.println("Actual="+actual);
         return actual;
         }
         */
        if (series.get(from + half).getStart() > row) {
            return findSeriesIndex(row, from, from + half);
        }
        if (series.get(from + half).getStart() < row) {
            return findSeriesIndex(row, from + half, to);
        }
        System.out.println("Can't Find ob " + row);
        return -1;
    }

    public int _findSeriesIndex(int row) {
        for (int i = 0; i < series.size(); i++) {
            if (series.get(i).contains(row)) {
                return i;
            }
            //}else{
            //System.out.println("Series:"+i+": doesn't contain row:"+row);
            //}
        }
        return -1;
    }

    @Override
    public String getValue(String s) {
        return getValue(columnMapper.getDataSetIndex(s));
    }

    @Override
    public void setValue(String s, String val) {
        if (!columnMapper.containsColumn(s)) {
            columnMapper.registerColumn(s, AttachmentLevel.DATASET);
        }
        setValue(columnMapper.getDataSetIndex(s), val);
    }

    @Override
    public String getValue(int i) {
        return columnValues.get(i);
    }

    @Override
    public void setValue(int i, String val) {
        if (columnValues.size() - 1 < i) {
            for (int j = columnValues.size() - 1; j < i; j++) {
                columnValues.add(null);
            }
        }
        columnValues.set(i, val);
    }

    public void updateIndexes() {
        int start = 0;
        int end = 0;
        for (Series s : series) {
            s.updateIndexes(start);
            end = end + s.size();
            s.setEnd(end);
            start = end;
            //s.dump();
        }
    }

    /**
     * @return the series
     */
    public List<Series> getSeriesList() {
        return series;
    }

    /**
     * @param series the series to set
     */
    public void setSeriesList(List<Series> series) {
        this.series = series;
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

    public FlatObs getFlatObs(int i) {
        FlatObs flat = new FlatObs(columnMapper.size());
        for (int j = 0; j < columnMapper.size(); j++) {
            flat.setValue(j, getValue(i, j));
        }
        return flat;
    }

    public FlatObs getFlatObsSansGroups(int i) {

        FlatObs flat = new FlatObs(columnMapper.size());
        for (int j = 0; j < columnMapper.size() && columnMapper.getAttachmentLevel(j) != AttachmentLevel.GROUP; j++) {
            flat.setValue(j, getValue(i, j));
        }
        return flat;

    }

    @Override
    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public int groupSize() {
        if (groups == null) {
            return 0;
        }
        return groups.size();
    }

    @Override
    public void setGroups(List<Group> groups) {
        this.groups = groups;
        if (groups == null) {
            return;
        }
        for (int i = 0; i < groups.size(); i++) {
            this.groups.get(i).processGroupValues(this);
        }
    }

    @Override
    public Cube query(Cube cube, List<String> order) {
        long time = System.currentTimeMillis();
        for (int i = 0; i < size(); i++) {
            cube.putObservation(order, columnMapper, getFlatObs(i));
            /*
             if( i % 100 == 0 ) {
             System.out.println("100 obs="+(time-System.currentTimeMillis()));
             time = System.currentTimeMillis();
             }
             */
        }
        return cube;
    }

    public FlatObs find(FullKey key) {
        boolean found = true;
        for (int i = 0; i < size(); i++) {
            FlatObs obs = getFlatObs(i);
            found = true;
            for (int j = 0; j < columnMapper.size() && !found; j++) {
                if (!key.getComponent(columnMapper.getColumnName(j)).equals(obs.getValue(j))) {
                    found = false;
                }
            }
            if (found) {
                return obs;
            }
        }
        return null;
    }
}
