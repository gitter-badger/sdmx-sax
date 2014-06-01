/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data.flat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import sdmx.data.ColumnMapper;
import sdmx.data.AttachmentLevel;

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
public class FlatColumnMapper implements ColumnMapper {
    List<String> columns = new ArrayList<String>();
    public int registerColumn(String s,AttachmentLevel attach) {
        if( attach!=AttachmentLevel.OBSERVATION&&attach!=AttachmentLevel.GROUP) {
            throw new RuntimeException("Attachment level is not OBSERVATION Or Group");
        }
        columns.add(s);
        return columns.indexOf(s);
    }
    public int getColumnIndex(String s) {
        return columns.indexOf(s);
    }
    public String getColumnName(int i) {
        return columns.get(i);
    }
    public int size() {
        return columns.size();
    }
    public boolean containsColumn(String name) {
        for(int i=0;i<columns.size();i++) {
            if( columns.get(i).equals(name))return true;
        }
        return false;
    }

    @Override
    public List<String> getAllColumns() {
        List<String> result = new ArrayList<String>();
        for(int i=0;i<columns.size();i++) {
            result.add(columns.get(i));
        }
        return result;
    }

    @Override
    public List<String> getObservationColumns() {
        List<String> result = new ArrayList<String>();
        for(int i=0;i<columns.size();i++) {
            result.add(columns.get(i));
        }
        return result;

    }

    @Override
    public List<String> getSeriesColumns() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<String> getDataSetColumns() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public List<String> getGroupColumns() {
        return Collections.EMPTY_LIST;
    }

    @Override
    public boolean isAttachedToDataSet(String s) {
        return false;
    }

    @Override
    public boolean isAttachedToDataSet(int i) {
        return false;
    }

    @Override
    public boolean isAttachedToSeries(String s) {
        return false;
    }

    @Override
    public boolean isAttachedToSeries(int i) {
        return false;
    }

    @Override
    public boolean isAttachedToObservation(String s) {
        return true;
    }

    @Override
    public boolean isAttachedToObservation(int i) {
        return true;
    }

    @Override
    public boolean isAttachedToGroup(String s) {
        return false;
    }

    @Override
    public boolean isAttachedToGroup(int i) {
        return false;
    }

    @Override
    public void dump() {
        System.out.println("Column Mapper");
       for(int i=0;i<size();i++) {
          System.out.println(i+"="+getColumnName(i));
       }
       
    }
}
