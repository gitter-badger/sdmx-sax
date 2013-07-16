/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.datastructure;

import java.util.List;
import sdmx.commonreferences.ConceptReferenceType;
import sdmx.query.base.ComponentWhereType;

/**
 *
 * @author James
 */
public class AttributeWhereType extends DataStructureComponentWhereType {
    private List<ConceptReferenceType> roles = null;

    /**
     * @return the roles
     */
    public List<ConceptReferenceType> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<ConceptReferenceType> roles) {
        this.roles = roles;
    }
}
