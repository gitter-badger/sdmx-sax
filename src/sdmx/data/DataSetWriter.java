/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.HashMap;
import sdmx.data.flat.FlatDataSet;

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
public interface DataSetWriter {
    //public ColumnMapper getColumnMapper();
    public void newDataSet();
    public void newSeries();
    public void newObservation();
    public void writeDataSetComponent(String name,String val);
    public void writeSeriesComponent(String name,String val);
    public void writeObservationComponent(String name,String val);
    public void writeGroupValues(String name,HashMap<String,Object> group);
    public void finishObservation();
    public void finishSeries();
    public DataSet finishDataSet();
}
