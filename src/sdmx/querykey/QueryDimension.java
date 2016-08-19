/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.querykey;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.structure.base.ItemType;
import sdmx.structure.datastructure.DataStructureType;

/**
 *
 * @author James
 */
public interface QueryDimension {
    public int size();
    public List<String> getValues();
    public void addValue(String s);
    public void removeValue(String s);
    public String getConcept();
    public String getQueryString();
    public List<ItemType> getPossibleValues();
}
