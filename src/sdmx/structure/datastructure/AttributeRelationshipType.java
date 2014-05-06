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
/**
 *  This file is part of SdmxSax.
 *
 *   SdmxSax is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 
 *   SdmxSax is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SdmxSax.  If not, see <http://www.gnu.org/licenses/>.
 *
 *  Copyright James Gardner 2014
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
