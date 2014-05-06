/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

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
public class AttributeType extends AttributeBaseType {

    private AttributeRelationshipType relation = null;
    private UsageStatusType usageStatus = null;

    /**
     * @return the relation
     */
    public AttributeRelationshipType getRelationshipType() {
        return relation;
    }

    /**
     * @param relation the relation to set
     */
    public void setRelationshipType(AttributeRelationshipType relation) {
        this.relation = relation;
    }

    /**
     * @return the usageStatus
     */
    public UsageStatusType getAssignmentStatus() {
        return usageStatus;
    }

    /**
     * @param usageStatus the usageStatus to set
     */
    public void setAssignmentStatus(UsageStatusType usageStatus) {
        this.usageStatus = usageStatus;
    }
}
