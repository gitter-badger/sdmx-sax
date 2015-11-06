/**
 * This file is part of SdmxSax.
 *
 * SdmxSax is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 *
 * SdmxSax is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along with
 * SdmxSax. If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright James Gardner 2014
 */
package sdmx.net.list;

import java.net.MalformedURLException;
import java.net.URL;
import sdmx.Queryable;
import sdmx.net.service.RESTQueryable;
import sdmx.net.service.opensdmx.OpenSDMXRESTQueryable;
import sdmx.net.service.ilo.ILORESTServiceRegistry;
import sdmx.net.service.knoema.KnoemaRESTServiceRegistry;
import sdmx.net.service.nomis.NOMISRESTServiceRegistry;

/**
 *
 * @author James
 */
public class NomisDataProvider extends DataProvider {

    private String agencyId = null;
    private URL serviceURL = null;
    private String options = "";

    public NomisDataProvider(int indx,String agency, String serviceURL,String options,String attribution,String htmlAttribution) throws MalformedURLException {
        super(indx,attribution,htmlAttribution);
        this.agencyId = agency;
        this.serviceURL = new URL(serviceURL);
        this.options=options;
    }

    public String getAgencyId() {
        return agencyId;
    }

    public Queryable getQueryable() {
        return new NOMISRESTServiceRegistry(agencyId, serviceURL.toString(),options);
    }
    public int getType() { return DataProvider.TYPE_ILO; }
    @Override
    public String getServiceURL() { return this.serviceURL.toString(); }
    @Override
    public String getOptions() { return ""; }
}
