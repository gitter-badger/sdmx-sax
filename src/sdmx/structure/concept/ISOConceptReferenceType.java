/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

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
public class ISOConceptReferenceType {
    private String agencyId = null;
    private String conceptSchemeId = null;
    private String conceptId = null;

    /**
     * @return the agencyId
     */
    public String getAgencyId() {
        return agencyId;
    }

    /**
     * @param agencyId the agencyId to set
     */
    public void setAgencyId(String agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * @return the conceptSchemeId
     */
    public String getConceptSchemeId() {
        return conceptSchemeId;
    }

    /**
     * @param conceptSchemeId the conceptSchemeId to set
     */
    public void setConceptSchemeId(String conceptSchemeId) {
        this.conceptSchemeId = conceptSchemeId;
    }

    /**
     * @return the conceptId
     */
    public String getConceptId() {
        return conceptId;
    }

    /**
     * @param conceptId the conceptId to set
     */
    public void setConceptId(String conceptId) {
        this.conceptId = conceptId;
    }
    
    
}
