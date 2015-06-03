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
