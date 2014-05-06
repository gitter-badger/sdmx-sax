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
