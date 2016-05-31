/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import sdmx.structure.base.Component;
import sdmx.structure.base.ComponentType;

/**
 *
 * @author James
 */

public class AttributeBaseType extends Component {
    @Override
    public SimpleDataStructureRepresentationType getLocalRepresentation() {
        return (SimpleDataStructureRepresentationType)super.getLocalRepresentation();
    }
    public void setLocalRepresentation(SimpleDataStructureRepresentationType loc) {
        super.setLocalRepresentation(loc);
    }
    
}
