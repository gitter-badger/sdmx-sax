/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.data;

import sdmx.commonreferences.NCNameIDType;

/**
 *
 * @author James
 */
public class ConceptValueType extends DataStructureComponentValueQueryType{
 public ConceptValueType(String id, String val) {
        super.setId(new NCNameIDType(id));
        super.setValue(val);
    }
    public boolean match(String value) {
        if( getValue().equals(value))return true;
        return false;
    }   
}
