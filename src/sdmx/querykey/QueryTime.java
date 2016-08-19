/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.querykey;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import sdmx.Registry;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public interface QueryTime extends QueryDimension {
    public Date getStartTime();
    public void setStartTime(Date d);
    public Date getEndTime();
    public void setEndTime(Date d);
}
