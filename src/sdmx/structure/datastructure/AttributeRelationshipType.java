/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.List;
import sdmx.commonreferences.LocalDimensionReference;
import sdmx.commonreferences.LocalGroupKeyDescriptorReference;
import sdmx.commonreferences.LocalPrimaryMeasureReference;

/**
 *
 * @author James
 */
/*
 SDMX-SAX an SDMX Parsing Library
Copyright (C) 2015  James Gardner

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
package sdmx;
 */
public class AttributeRelationshipType {
// One of;
    // a
    private Boolean empty = false;
    // b
    private List<LocalDimensionReference> dimensions = null;
    private LocalGroupKeyDescriptorReference attachGroup = null;
    // c
    private List<LocalGroupKeyDescriptorReference> groups = null;
    // d
    private LocalPrimaryMeasureReference primaryMeasure = null;

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
    public LocalGroupKeyDescriptorReference getAttachGroup() {
        return attachGroup;
    }

    /**
     * @param attachGroup the attachGroup to set
     */
    public void setAttachGroup(LocalGroupKeyDescriptorReference attachGroup) {
        this.attachGroup = attachGroup;
    }

    /**
     * @return the primaryMeasure
     */
    public LocalPrimaryMeasureReference getPrimaryMeasure() {
        return primaryMeasure;
    }

    /**
     * @param primaryMeasure the primaryMeasure to set
     */
    public void setPrimaryMeasure(LocalPrimaryMeasureReference primaryMeasure) {
        this.primaryMeasure = primaryMeasure;
    }

    /**
     * @return the groups
     */
    public List<LocalGroupKeyDescriptorReference> getGroups() {
        return groups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(List<LocalGroupKeyDescriptorReference> groups) {
        this.groups = groups;
    }

    /**
     * @return the dimensions
     */
    public List<LocalDimensionReference> getDimensions() {
        return dimensions;
    }

    /**
     * @param dimensions the dimensions to set
     */
    public void setDimensions(List<LocalDimensionReference> dimensions) {
        this.dimensions = dimensions;
    }

  
    
    
    
}
