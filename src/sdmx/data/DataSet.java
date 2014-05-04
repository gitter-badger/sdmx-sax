/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.List;
import sdmx.common.ActionType;
import sdmx.data.flat.FlatObs;
import sdmx.data.key.FullKey;
import sdmx.data.key.PartialKey;
import sdmx.query.data.DataQuery;

/**
 *
 * @author James
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
    public List<FlatObs> query(PartialKey key);
    public FlatObs query(FullKey key);
    public ColumnMapper getColumnMapper();
    public void setGroups(List<Group> groups);
    public List<Group> getGroups();
    public int groupSize();
    }
