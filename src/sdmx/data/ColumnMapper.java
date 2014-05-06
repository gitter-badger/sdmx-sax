/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.data;

import java.util.List;

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
public interface ColumnMapper {
    public int registerColumn(String s,AttachmentLevel attach);
    public int getColumnIndex(String s);
    public String getColumnName(int i);
    public int size();
    public boolean containsColumn(String name);
    public List<String> getAllColumns();
    public List<String> getObservationColumns();
    public List<String> getSeriesColumns();
    public List<String> getDataSetColumns();
    public List<String> getGroupColumns();
    public boolean isAttachedToDataSet(String s);
    public boolean isAttachedToDataSet(int i);
    public boolean isAttachedToSeries(String s);
    public boolean isAttachedToSeries(int i);
    public boolean isAttachedToObservation(String s);
    public boolean isAttachedToObservation(int i);
    public boolean isAttachedToGroup(String s);
    public boolean isAttachedToGroup(int i);
    public void dump();
    
}
