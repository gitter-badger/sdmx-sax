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
public class QueryTime {
    String concept = null;
    Registry reg = null;
    DataStructureType struct = null;
    Date startTime = new Date();
    Date endTime = new Date();
    public QueryTime(String concept,DataStructureType struct,Registry reg){
        this.concept=concept;
        this.struct=struct;
        this.reg=reg;
        
    }
    public Date getStartTime() { return this.startTime; }
    public void setStartTime(Date d) { this.startTime=d; }
    public Date getEndTime() { return this.endTime; }
    public void setEndTime(Date d) { this.endTime=d; }
}
