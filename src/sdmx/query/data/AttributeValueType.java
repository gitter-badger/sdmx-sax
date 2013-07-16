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
public class AttributeValueType extends DataStructureComponentValueQueryType {
    public AttributeValueType(String id, String val) {
        super.setId(new NCNameIDType(id));
        super.setValue(val);
    }    
}
