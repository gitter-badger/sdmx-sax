/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.List;
import sdmx.commonreferences.LocalDimensionReferenceType;
import sdmx.commonreferences.LocalGroupKeyDescriptorReferenceType;
import sdmx.commonreferences.LocalPrimaryMeasureReferenceType;

/**
 *
 * @author James
 */
public class AttributeRelationshipType {
// One of;
    // a
    private Boolean empty = false;
    // b
    private List<LocalDimensionReferenceType> dimensions = null;
    private LocalGroupKeyDescriptorReferenceType attachGroup = null;
    // c
    private List<LocalGroupKeyDescriptorReferenceType> groups = null;
    // d
    private LocalPrimaryMeasureReferenceType primaryMeasure = null;

    /**
     * @return the empty
     */
    public boolean isEmpty() {
        return empty==null?false:empty.booleanValue();
    }

    /**
     * @param empty the empty to set
     */
    public void setEmpty(boolean empty) {
        this.empty = empty;
    }


    /**
     * @return the attachGroup
     */
    public LocalGroupKeyDescriptorReferenceType getAttachGroup() {
        return attachGroup;
    }

    /**
     * @param attachGroup the attachGroup to set
     */
    public void setAttachGroup(LocalGroupKeyDescriptorReferenceType attachGroup) {
        this.attachGroup = attachGroup;
    }

    /**
     * @return the primaryMeasure
     */
    public LocalPrimaryMeasureReferenceType getPrimaryMeasure() {
        return primaryMeasure;
    }

    /**
     * @param primaryMeasure the primaryMeasure to set
     */
    public void setPrimaryMeasure(LocalPrimaryMeasureReferenceType primaryMeasure) {
        this.primaryMeasure = primaryMeasure;
    }

    /**
     * @return the groups
     */
    public List<LocalGroupKeyDescriptorReferenceType> getGroups() {
        return groups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(List<LocalGroupKeyDescriptorReferenceType> groups) {
        this.groups = groups;
    }

    /**
     * @return the dimensions
     */
    public List<LocalDimensionReferenceType> getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(List<LocalDimensionReferenceType> dimensions) {
        this.dimensions = dimensions;
    }

  
    
    
    
}
