/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.metadataflow;

import sdmx.common.MetadataStructureReferenceType;
import sdmx.structure.base.StructureUsageType;

/**
 *
 * @author James
 */

public class MetadataflowType extends StructureUsageType {
    public MetadataStructureReferenceType getMetadataStructureReference() {
        return (MetadataStructureReferenceType)super.getStructure();
    }
    public void setMetadataStructureReference(MetadataStructureReferenceType msr) {
        super.setStructure(msr);
    }
}
