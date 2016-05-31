/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.structure;

import sdmx.structure.organisation.DataConsumerSchemeType;
import sdmx.structure.organisation.AgencySchemeType;
import sdmx.structure.organisation.DataProviderSchemeType;
import sdmx.structure.organisation.OrganisationUnitSchemeType;

/**
 *
 * @author James
 */

public class OrganisationSchemesType {
     private AgencySchemeType agencyScheme = null;
     private DataConsumerSchemeType dataConsumerScheme = null;
     private DataProviderSchemeType dataProviderScheme = null;
     private OrganisationUnitSchemeType organisationUnitScheme = null;

    /**
     * @return the agencyScheme
     */
    public AgencySchemeType getAgencyScheme() {
        return agencyScheme;
    }

    /**
     * @param agencyScheme the agencyScheme to set
     */
    public void setAgencyScheme(AgencySchemeType agencyScheme) {
        this.agencyScheme = agencyScheme;
    }

    /**
     * @return the dataConsumerScheme
     */
    public DataConsumerSchemeType getDataConsumerScheme() {
        return dataConsumerScheme;
    }

    /**
     * @param dataConsumerScheme the dataConsumerScheme to set
     */
    public void setDataConsumerScheme(DataConsumerSchemeType dataConsumerScheme) {
        this.dataConsumerScheme = dataConsumerScheme;
    }

    /**
     * @return the dataProviderScheme
     */
    public DataProviderSchemeType getDataProviderScheme() {
        return dataProviderScheme;
    }

    /**
     * @param dataProviderScheme the dataProviderScheme to set
     */
    public void setDataProviderScheme(DataProviderSchemeType dataProviderScheme) {
        this.dataProviderScheme = dataProviderScheme;
    }

    /**
     * @return the organisationUnitScheme
     */
    public OrganisationUnitSchemeType getOrganisationUnitScheme() {
        return organisationUnitScheme;
    }

    /**
     * @param organisationUnitScheme the organisationUnitScheme to set
     */
    public void setOrganisationUnitScheme(OrganisationUnitSchemeType organisationUnitScheme) {
        this.organisationUnitScheme = organisationUnitScheme;
    }
     
}
