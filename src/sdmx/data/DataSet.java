/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

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
    public Object getValue(int row, int col);
    public Object getValue(int row, String col);
    public void setValue(int row, int col,Object val);
    public void setValue(int row, String col,Object val);
    public void writeTo(DataSetWriter writer);
    public DataSet query(DataQuery query);
    public DataSet query(DataQuery query,DataSetWriter dsw);
   }
