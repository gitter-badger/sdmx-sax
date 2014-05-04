/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sdmx.combined;

import sdmx.Registry;
import sdmx.data.DataSet;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public class DecoratedDataSet {
    private DataSet dataSet = null;
    private Registry registry = null;
    private DataStructureType structure = null;
    public DecoratedDataSet(DataSet ds,Registry reg,DataStructureType struct){
        this.dataSet=ds;
        this.registry=reg;
        this.structure=struct;
    }
    public DecoratedValue getDecoratedValue(int row, int column) {
        return new DecoratedValue(dataSet.getColumnName(column),dataSet.getValue(row,column),registry,structure);
    }
}
