/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.querykey.impl;

import java.util.Date;
import sdmx.Registry;
import sdmx.querykey.QueryTime;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class RegistryQueryTime extends RegistryQueryDimension implements QueryTime {
    String concept = null;
    Registry reg = null;
    DataStructureType struct = null;
    Date startTime = new Date();
    Date endTime = new Date();
    public RegistryQueryTime(String concept,DataStructureType struct,Registry reg){
        super(concept,struct,reg);
        this.concept=concept;
        this.struct=struct;
        this.reg=reg;
        
    }
    public Date getStartTime() { return this.startTime; }
    public void setStartTime(Date d) { this.startTime=d; }
    public Date getEndTime() { return this.endTime; }
    public void setEndTime(Date d) { this.endTime=d; }    
}
