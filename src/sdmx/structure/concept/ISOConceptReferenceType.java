/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

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
