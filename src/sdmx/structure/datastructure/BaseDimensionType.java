/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.datastructure;

import java.util.List;
import sdmx.common.DimensionTypeType;
import sdmx.commonreferences.ConceptReferenceType;

/**
 *
 * @author James
 */
public class BaseDimensionType extends BaseDimensionBaseType {
    private List<ConceptReferenceType> roles = null;
    private Integer position = null;
    private DimensionTypeType type = null;

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

    /**
     * @return the position
     */
    public Integer getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(Integer position) {
        this.position = position;
    }

    /**
     * @return the type
     */
    public DimensionTypeType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(DimensionTypeType type) {
        this.type = type;
    }
    
}
