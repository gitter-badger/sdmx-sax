/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.query.datastructure;

import java.util.List;
import sdmx.commonreferences.ConceptReference;
import sdmx.query.base.ComponentWhereType;

/**
 *
 * @author James
 */

public class DimensionWhereType extends ComponentWhereType {
    private List<ConceptReference> roles = null;

    /**
     * @return the roles
     */
    public List<ConceptReference> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<ConceptReference> roles) {
        this.roles = roles;
    }
}
