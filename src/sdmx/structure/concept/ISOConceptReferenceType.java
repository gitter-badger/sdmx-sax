/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure.concept;

/**
 *
 * @author James
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
