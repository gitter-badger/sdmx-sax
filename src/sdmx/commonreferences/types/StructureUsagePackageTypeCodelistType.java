/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.commonreferences.types;

/**
 *
 * @author James
 */

public class StructureUsagePackageTypeCodelistType extends PackageTypeCodelistType {
    public static final String TARGET_DATASTRUCTURE = "datastructure";
    public static final StructureUsagePackageTypeCodelistType DATASTRUCTURE = new StructureUsagePackageTypeCodelistType(TARGET_DATASTRUCTURE);
    public StructureUsagePackageTypeCodelistType(String s){
        super(s);
    }
}
