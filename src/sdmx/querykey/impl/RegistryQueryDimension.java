/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.querykey.impl;

import java.util.ArrayList;
import java.util.List;
import sdmx.Registry;
import sdmx.querykey.QueryDimension;
import sdmx.structure.base.ItemType;
import sdmx.structure.datastructure.DataStructureType;
import sdmx.structureddata.ValueTypeResolver;

/**
 *
 * @author James
 */
public class RegistryQueryDimension implements QueryDimension {
 
    String concept = null;
    Registry reg = null;
    DataStructureType struct = null;
    List<String> values = null;

    public RegistryQueryDimension(String concept, DataStructureType struct, Registry reg) {
        this.concept = concept;
        this.struct = struct;
        this.reg = reg;
        this.values = new ArrayList<String>();
    }

    public int size() {
        return this.values.size();
    }

    public List<String> getValues() {
        return this.values;
    }

    public void addValue(String s) {
        this.values.add(s);
    }

    public void removeValue(String s) {
        this.values.remove(s);
    }

    public String getConcept() {
        return this.concept;
    }
    public List<ItemType> getPossibleValues() {
        return ValueTypeResolver.getPossibleCodes(reg, struct, concept).getItems();
    }
    public String getQueryString() {
        String q = "";
        for (int i = 0; i < this.values.size(); i++) {
            q += values.get(i);
            if (i < values.size() - 1) {
                q += "+";
            }
        }
        return q;
    }   
}
