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
