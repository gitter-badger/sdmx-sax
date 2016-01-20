/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import sdmx.cube.Cube;
import java.util.List;
import sdmx.Registry;
import sdmx.common.ActionType;
import sdmx.commonreferences.DataStructureReference;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.data.key.PartialKey;
import sdmx.query.data.DataQuery;

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
public interface DataSet {
    public void dump();
    public String getColumnName(int i);
    public int getColumnIndex(String s);
    public int getColumnSize();
    public int size();
    public String getValue(int row, int col);
    public String getValue(int row, String col);
    public void setValue(int row, int col,String val);
    public void setValue(int row, String col,String val);
    public void writeTo(DataSetWriter writer);
    public FlatObs getFlatObs(int row);
    public Cube query(Cube cube,List<String> order);
    public ColumnMapper getColumnMapper();
    public void setGroups(List<Group> groups);
    public List<Group> getGroups();
    public int groupSize();
    public FlatObs find(FullKey key);
    }
