/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

/**
 *
 * @author James
 */
public class DimensionType extends BaseDimensionType {

    public void dump() {
        System.out.println("Dimension:"+getId());
        System.out.println("pos:"+getPosition());
    }
    
}
