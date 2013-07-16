/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

/**
 *
 * @author James
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
